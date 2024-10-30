package bootcamp.com.bc_yahoo_finance.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import bootcamp.com.bc_yahoo_finance.model.TStockDTO;
import bootcamp.com.bc_yahoo_finance.service.TStockService;

@RestController
public class TStockController implements TStockOperation{

  @Autowired
  private TStockService tStockService;


  @Override
  public List<TStockDTO> getTstock() {
    return tStockService.getTStockDTO();
  }

  

  
}
