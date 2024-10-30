package bootcamp.com.bc_yahoo_finance.service.Impl;

import java.io.IOException;
import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import bootcamp.com.bc_yahoo_finance.entity.TStockEntity;
import bootcamp.com.bc_yahoo_finance.infra.yahoo.CookieManager;
import bootcamp.com.bc_yahoo_finance.infra.yahoo.CrumbManager;
import bootcamp.com.bc_yahoo_finance.infra.yahoo.YHRestClient;
import bootcamp.com.bc_yahoo_finance.mapper.StockMapper;
import bootcamp.com.bc_yahoo_finance.model.DBStockDTO;
import bootcamp.com.bc_yahoo_finance.model.TStockDTO;
import bootcamp.com.bc_yahoo_finance.repository.StockRepository;
import bootcamp.com.bc_yahoo_finance.service.TStockService;

@Service
public class TStockServiceImpl implements TStockService {

    private CookieManager cookieManager;
    private CrumbManager crumbManager;
    private YHRestClient yhRestClient;
    private StockRepository stockRepository;

    // Constructor injection for dependencies
    @Autowired
    public TStockServiceImpl(CookieManager cookieManager, CrumbManager crumbManager, YHRestClient yhRestClient,
            StockRepository stockRepository) {
        this.cookieManager = cookieManager;
        this.crumbManager = crumbManager;
        this.yhRestClient = yhRestClient;
        this.stockRepository = stockRepository;
    }

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private StockMapper stockMapper;

    @Autowired
    private ObjectMapper objectMapper;

    @Override
    public List<TStockDTO> getTStockDTO() {

        // Fetch stock symbols from the database
        List<String> stockSymbols = stockRepository.findAll()
                .stream()
                .map(TStockEntity::getSymbol)
                .collect(Collectors.toList());

        // Get cookie and crumb
        // String cookie = cookieManager.getResponse();
        // String crumb = crumbManager.getCrumb();

        // Fetch StockDTOs using YHRestClient
        // List<TStockDTO> stockDTOList = yhRestClient.getQuote();

        // Return the list of StockDF
        return null;

    }

    @Override
    public List<TStockEntity> saveAll(List<TStockEntity> tStockEntities) {
        return stockRepository.saveAll(tStockEntities);
    }

    @Override
    public List<TStockDTO> getAll() throws JsonProcessingException {
        // if redis key exists, get the value (json string)
        String json = (String) this.redisTemplate.opsForValue().get("db-stock");
        if (json == null) {
            System.out.println("Redis not found.");
            // read from DB
            List<TStockEntity> tStockEntities = stockRepository.findAll();
            List<TStockDTO> dbstocks = tStockEntities.stream() //
                    .map(e -> this.stockMapper.map(e)) //
                    .collect(Collectors.toList());
            // write to Redis ...
            String stockString = this.objectMapper.writeValueAsString(dbstocks);
            System.out.println("dbstocks : " + dbstocks);
            System.out.println("stockString : " + stockString);

            this.redisTemplate.opsForValue().set("db-stock", stockString,
                    Duration.ofMinutes(10));
            return dbstocks;
        }
        return Arrays.asList(this.objectMapper.readValue(json, TStockEntity[].class))
                .stream() //
                .map(e -> this.stockMapper.map(e)) //
                .collect(Collectors.toList());
    }

}
