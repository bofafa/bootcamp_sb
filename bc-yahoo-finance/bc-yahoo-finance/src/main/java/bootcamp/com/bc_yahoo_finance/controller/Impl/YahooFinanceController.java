package bootcamp.com.bc_yahoo_finance.controller.Impl;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;

import bootcamp.com.bc_yahoo_finance.controller.YahooFinanceOperation;
import bootcamp.com.bc_yahoo_finance.entity.StockPriceEntity;
import bootcamp.com.bc_yahoo_finance.model.dto.StockPriceDTO;
import bootcamp.com.bc_yahoo_finance.model.dto.YahooQuoteDTO;
import bootcamp.com.bc_yahoo_finance.service.StockService;
import bootcamp.com.bc_yahoo_finance.service.YahooFinanceService;


@RestController
@RequestMapping (value = "/v1")
public class YahooFinanceController implements YahooFinanceOperation{

  @Autowired
  private YahooFinanceService yahooFinanceService;

  @Autowired
  private StockService stockService;

  @Override
  public YahooQuoteDTO getQuote(List<String> symbols) throws JsonProcessingException {
    return yahooFinanceService.getQuote(symbols);
  }

}

