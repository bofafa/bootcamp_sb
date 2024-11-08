package bootcamp.com.bc_yahoo_finance.service.Impl;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import bootcamp.com.bc_yahoo_finance.entity.StockEntity;
import bootcamp.com.bc_yahoo_finance.entity.StockPriceEntity;
import bootcamp.com.bc_yahoo_finance.exception.BusinessException;
import bootcamp.com.bc_yahoo_finance.exception.ErrorCode;
import bootcamp.com.bc_yahoo_finance.mapper.StockMapper;
import bootcamp.com.bc_yahoo_finance.mapper.StockPriceMapper;
import bootcamp.com.bc_yahoo_finance.model.Stock;
import bootcamp.com.bc_yahoo_finance.model.dto.StockPriceDTO;
import bootcamp.com.bc_yahoo_finance.repository.StockPriceRepository;
import bootcamp.com.bc_yahoo_finance.repository.StockRepository;
import bootcamp.com.bc_yahoo_finance.service.StockService;
import jakarta.transaction.Transactional;

@Service
public class StockServiceImpl implements StockService {
  @Autowired
  private StockRepository stockRepository;

  @Autowired
  private StockPriceRepository stockPriceRepository;

  @Autowired
  private RedisTemplate<String, String> redisTemplate;
  
  @Autowired
  private StockMapper stockMapper;
  
  @Autowired
  private ObjectMapper objectMapper;

  @Override
  public List<StockEntity> saveAll(List<StockEntity> entities) {
    return this.stockRepository.saveAll(entities);
  }

  @Override
  public List<StockEntity> findAll() {
    return this.stockRepository.findAll();
  }

  @Override
  public StockEntity findBySymbol(String symbol) {
    return this.stockRepository.findBySymbol(symbol).orElseThrow(
        () -> new BusinessException(ErrorCode.Entity_NOT_FOUND_EX));
  }

  @Override
  public List<Stock> findAllWithCache() throws JsonProcessingException {
    // read from Redis ...
    String json = this.redisTemplate.opsForValue().get("stock-list");
    if (json == null) {
      // read from DB ...
      List<Stock> stocks = this.stockRepository.findAll().stream() //
          .map(s -> this.stockMapper.map(s)) //
          .collect(Collectors.toList());
      // write to Redis ...
      String jsonToWrite = this.objectMapper.writeValueAsString(stocks);
      this.redisTemplate.opsForValue().set("stock-list", jsonToWrite,
          Duration.ofMinutes(10));
      return stocks;
    }
    StockEntity[] stockEntities =
        this.objectMapper.readValue(json, StockEntity[].class);
    return Arrays.asList(stockEntities).stream() //
        .map(e -> this.stockMapper.map(e)) //
        .collect(Collectors.toList());
  }

  @Override
  public String getMaxDay(String symbol) {
    String json = this.redisTemplate.opsForValue().get(symbol);
    if (json == null) {
      List<String> date = this.stockPriceRepository.findAll().stream()
          .map(d -> d.getMarketDateTime().toLocalDate().toString())
          .collect(Collectors.toList());
      String maxDate = date.stream() // 如果需要最大日期
          .max(String::compareTo) // 獲取最大日期
          .orElse("No data available");

      return "SYSDATE-" + symbol + ": " + maxDate;
    }
    return "SYSDATE-" + symbol + ":" + json;
  }
  @Autowired
  private StockPriceMapper stockPriceMapper;

  @Override
  public StockPriceDTO getFiveMinData(String symbol) throws JsonProcessingException {
    String redisKey = "5MIN-" + symbol;
    String jsonData = redisTemplate.opsForValue().get(redisKey);
    StockPriceDTO stockPriceDTO = new StockPriceDTO();
    if (jsonData == null) {
      List<StockPriceEntity> stockPriceEntities = loadFiveMinDataFromDatabase(symbol);
      if (!stockPriceEntities.isEmpty()) {
        List<StockPriceDTO.Data> dataList = stockPriceEntities.stream()
          .map(stockPriceMapper::mapToData)
          .collect(Collectors.toList());
        stockPriceDTO.setRegularMarketTime(stockPriceEntities.get(0).getMarketDateTime().toEpochSecond(ZoneOffset.UTC));
        stockPriceDTO.setData(dataList);
        jsonData = objectMapper.writeValueAsString(stockPriceDTO);
        redisTemplate.opsForValue().set(redisKey, jsonData, 12, TimeUnit.HOURS);
      }
    } else {
      stockPriceDTO = objectMapper.readValue(jsonData, StockPriceDTO.class);
    }
    return stockPriceDTO;
  }

  private List<StockPriceEntity> loadFiveMinDataFromDatabase(String symbol) {
    List<StockPriceEntity> stockPriceEntities = stockPriceRepository.findBySymbol(symbol);
    stockPriceEntities.forEach(stockPriceEntity -> {
      LocalDateTime marketDateTime = stockPriceEntity.getMarketDateTime();
      LocalDateTime roundedDateTime = marketDateTime.withMinute((marketDateTime.getMinute() / 5) * 5 + 5).withSecond(0).withNano(0);
      stockPriceEntity.setMarketDateTime(roundedDateTime);
    });
    return stockPriceEntities;
  }
}