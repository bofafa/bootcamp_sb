package bootcamp.com.bc_yahoo_finance.service;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;

import bootcamp.com.bc_yahoo_finance.entity.StockEntity;
import bootcamp.com.bc_yahoo_finance.entity.StockPriceEntity;
import bootcamp.com.bc_yahoo_finance.model.Stock;
import bootcamp.com.bc_yahoo_finance.model.dto.StockPriceDTO;


public interface StockService {
  List<StockEntity> saveAll(List<StockEntity> entities);
  List<StockEntity> findAll();
  List<Stock> findAllWithCache() throws JsonProcessingException;
  StockEntity findBySymbol(String Symbol);

  String getMaxDay(String symbol);
  public StockPriceDTO getFiveMinData(String symbol)  throws JsonProcessingException;
}