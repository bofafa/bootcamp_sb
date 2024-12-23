package bootcamp.com.bc_yahoo_finance.mapper;

import org.springframework.stereotype.Component;

import bootcamp.com.bc_yahoo_finance.entity.TransactionEntity;
import bootcamp.com.bc_yahoo_finance.model.dto.Stock;
import bootcamp.com.bc_yahoo_finance.entity.StockEntity;

@Component
public class StockMapper {
  public Stock map(StockEntity entity) {
    return Stock.builder() //
        .id(entity.getId()) //
        .symbol(entity.getSymbol()) //
        .build();
  }
}