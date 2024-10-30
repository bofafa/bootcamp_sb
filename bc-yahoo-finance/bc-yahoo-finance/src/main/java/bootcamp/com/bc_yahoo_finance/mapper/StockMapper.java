package bootcamp.com.bc_yahoo_finance.mapper;

import org.springframework.stereotype.Component;

import bootcamp.com.bc_yahoo_finance.entity.TStockEntity;
import bootcamp.com.bc_yahoo_finance.model.DBStockDTO;
import bootcamp.com.bc_yahoo_finance.model.TStockDTO;

@Component
public class StockMapper {
  public TStockDTO map(TStockEntity tStockEntity) {
 
    return TStockDTO.builder() //
        .id(tStockEntity.getId()) //
        .symbol(tStockEntity.getSymbol()) //
  
        .build();
  }
}
