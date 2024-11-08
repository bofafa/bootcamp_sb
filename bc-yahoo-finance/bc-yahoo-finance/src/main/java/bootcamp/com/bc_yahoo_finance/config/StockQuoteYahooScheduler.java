package bootcamp.com.bc_yahoo_finance.config;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import com.fasterxml.jackson.core.JsonProcessingException;

import bootcamp.com.bc_yahoo_finance.entity.StockEntity;
import bootcamp.com.bc_yahoo_finance.entity.StockPriceEntity;
import bootcamp.com.bc_yahoo_finance.mapper.StockPriceMapper;
import bootcamp.com.bc_yahoo_finance.model.Stock;
import bootcamp.com.bc_yahoo_finance.model.dto.YahooQuoteDTO;
import bootcamp.com.bc_yahoo_finance.repository.StockPriceRepository;
import bootcamp.com.bc_yahoo_finance.service.StockService;
import bootcamp.com.bc_yahoo_finance.service.YahooFinanceService;
@Component
public class StockQuoteYahooScheduler {
  @Autowired
  private YahooFinanceService yahooFinanceService; 
  @Autowired
  private StockPriceMapper stockPriceMapper; 
  @Autowired
  private StockService stockService; 
  @Autowired
  private StockPriceRepository stockPriceRepository;
  @Autowired
  private RedisTemplate<String, String> redisTemplate;

  // 定時任務，喺星期一至五 9 點鐘每隔幾分鐘執行一次
  @Scheduled(cron = "0 34,39,44,49,54,59 9 * * MON-FRI",
      zone = "Asia/Hong_Kong")
  // 定時任務，喺星期一至五 10 點至 15 點之間每隔幾分鐘執行一次
  @Scheduled(cron = "0 4,9,14,19,24,29,34,39,44,49,54,59 10-15 * * MON-FRI",
     zone = "Asia/Hong_Kong")
  public void stockQuote() throws JsonProcessingException {
    // 查詢所有需要處理嘅股票列表
    List<Stock> stocks = this.stockService.findAllWithCache();
    if (stocks == null || stocks.isEmpty()) {
      return; // 如果冇股票需要處理，直接返回
    }
    
    // 提取所有股票嘅 symbol
    List<String> symbols = stocks.stream()
        .map(Stock::getSymbol)
        .collect(Collectors.toList());
    
    // 從 Yahoo Finance 拉取股票報價數據
    YahooQuoteDTO quoteDTO = this.yahooFinanceService.getQuote(symbols);
    if (quoteDTO.getBody() == null || quoteDTO.getBody().getResults() == null) {
      return; // 如果拉取嘅數據係空，直接返回
    }
    
    // 遍歷每一個股票數據
    quoteDTO.getBody().getResults().forEach(s -> {
      // 根據 symbol 查詢相應嘅 StockEntity
      StockEntity stockEntity = this.stockService.findBySymbol(s.getSymbol());
      if (stockEntity == null) {
        return; // 如果搵唔到相應嘅股票，返回
      }
      
      // 用 Mapper 將 Yahoo 數據轉換成 StockPriceEntity
      StockPriceEntity stockPriceEntity = this.stockPriceMapper.map(s);
      if (stockPriceEntity == null) {
        return; // 如果映射失敗，返回
      }
      
      // 設置 StockPriceEntity 嘅屬性
      stockPriceEntity.setStock(stockEntity);
      stockPriceEntity.setSymbol(stockEntity.getSymbol());
      stockPriceEntity.setTranType("5MIN"); // 交易類型設置為 "5MIN"
      
      try {
        // 保存股價數據到數據庫
        this.stockPriceRepository.save(stockPriceEntity);
        System.out.println("stockPriceEntity**********" + stockPriceEntity);

        // 保存股價數據到 Redis
        String redisKey = stockEntity.getSymbol();
        LocalDateTime marketDateTime = stockPriceEntity.getMarketDateTime();
        LocalDateTime roundedDateTime = marketDateTime.withMinute((marketDateTime.getMinute() / 5) * 5 + 5).withSecond(0).withNano(0);
        String formattedDate = roundedDateTime.format(DateTimeFormatter.ISO_LOCAL_DATE_TIME);
        redisTemplate.opsForValue().set(redisKey, formattedDate, 8, TimeUnit.HOURS);
      } catch (Exception e) {
        // 如果保存過程中發生錯誤，打印出錯誤信息
        System.err.println("Error saving stockPriceEntity: " + e.getMessage());
      }
    });
  }

  // 定時任務，喺每日 4:30 清除 Redis 嘅數據
  @Scheduled(cron = "0 30 16 * * *", zone = "Asia/Hong_Kong")
  public void clearRedisData() {
    try {
      Set<String> keys = redisTemplate.keys("*");
      if (keys != null && !keys.isEmpty()) {
        redisTemplate.delete(keys);
        System.out.println("Redis data cleared at 4:30 PM");
      }
    } catch (Exception e) {
      System.err.println("Error clearing Redis data: " + e.getMessage());
    }
  }
}
