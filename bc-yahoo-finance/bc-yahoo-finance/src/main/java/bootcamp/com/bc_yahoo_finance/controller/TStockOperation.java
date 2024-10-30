package bootcamp.com.bc_yahoo_finance.controller;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import bootcamp.com.bc_yahoo_finance.model.TStockDTO;
public interface TStockOperation {
  @GetMapping ("/tstock")
  List<TStockDTO>getTstock();

 
}
