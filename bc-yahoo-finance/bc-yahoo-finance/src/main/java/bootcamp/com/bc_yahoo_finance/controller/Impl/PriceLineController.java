package bootcamp.com.bc_yahoo_finance.controller.Impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;

import bootcamp.com.bc_yahoo_finance.controller.PriceLineOperation;
import bootcamp.com.bc_yahoo_finance.infra.web.ApiResp;
import bootcamp.com.bc_yahoo_finance.model.Base;
import bootcamp.com.bc_yahoo_finance.model.Candle;
import bootcamp.com.bc_yahoo_finance.model.PriceLine;
import bootcamp.com.bc_yahoo_finance.service.TransactionService;

@RestController
public class PriceLineController implements PriceLineOperation {
  @Autowired
  private TransactionService transactionService;

  @Override
  public ApiResp<PriceLine<Base>> getBasePrices(String symbol)
      throws JsonProcessingException {
    PriceLine<Base> priceline = transactionService.get5MinBase(symbol);
    System.out.println("priceline=" + priceline);
    return ApiResp.<PriceLine<Base>>builder() //
        .ok() //
        .data(priceline) //
        .build();
  }

  @Override
  public ApiResp<PriceLine<Candle>> getCandlePrices(String symbol)
      throws JsonProcessingException {
    PriceLine<Candle> priceline = transactionService.get5MinCandle(symbol);
    return ApiResp.<PriceLine<Candle>>builder() //
        .ok() //
        .data(priceline) //
        .build();
  }
}
