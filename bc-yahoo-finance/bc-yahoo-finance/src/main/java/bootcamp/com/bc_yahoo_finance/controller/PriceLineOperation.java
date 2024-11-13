package bootcamp.com.bc_yahoo_finance.controller;

import java.io.IOException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;

import bootcamp.com.bc_yahoo_finance.entity.TransactionEntity;
import bootcamp.com.bc_yahoo_finance.infra.web.ApiResp;

import bootcamp.com.bc_yahoo_finance.model.PriceLine;
import bootcamp.com.bc_yahoo_finance.model.Base;
import bootcamp.com.bc_yahoo_finance.model.Candle;
import bootcamp.com.bc_yahoo_finance.service.StockService;
import bootcamp.com.bc_yahoo_finance.service.YahooFinanceService;

public interface PriceLineOperation {
  @GetMapping("/priceline/base")
  ApiResp<PriceLine<Base>> getBasePrices(@RequestParam String symbol)
      throws JsonProcessingException;

  @GetMapping("/priceline/candle")
  ApiResp<PriceLine<Candle>> getCandlePrices(@RequestParam String symbol)
      throws JsonProcessingException;
}
