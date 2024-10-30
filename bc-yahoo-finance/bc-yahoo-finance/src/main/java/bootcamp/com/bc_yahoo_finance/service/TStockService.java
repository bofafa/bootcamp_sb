package bootcamp.com.bc_yahoo_finance.service;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;

import bootcamp.com.bc_yahoo_finance.entity.TStockEntity;
import bootcamp.com.bc_yahoo_finance.model.DBStockDTO;
import bootcamp.com.bc_yahoo_finance.model.TStockDTO;

public interface TStockService {
    List <TStockDTO> getTStockDTO();

     //String getYahooCookies();

  List<TStockDTO> getAll() throws JsonProcessingException;
  List<TStockEntity> saveAll (List<TStockEntity> tStockEntities);
}
