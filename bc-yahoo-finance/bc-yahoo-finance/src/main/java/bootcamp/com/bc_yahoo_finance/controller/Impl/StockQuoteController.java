package bootcamp.com.bc_yahoo_finance.controller.Impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import bootcamp.com.bc_yahoo_finance.entity.StockPriceEntity;
import bootcamp.com.bc_yahoo_finance.service.StockService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;





@RestController
@RequestMapping("/api/stocks")
public class StockQuoteController {

@Autowired
  private StockService stockService;

  @GetMapping ("/5min/{symbol}")
  public ResponseEntity<?> getFiveMinData(@PathVariable String symbol) {
    try {
      List<StockPriceEntity> stockPriceEntities = stockService.getFiveMinData(symbol);
      if (stockPriceEntities.isEmpty()) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No data available for symbol: " + symbol);
      }
      return ResponseEntity.ok(stockPriceEntities);
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error retrieving 5-min data: " + e.getMessage());
    }
  }
}