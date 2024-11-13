package bootcamp.com.bc_yahoo_finance.service;



import java.util.List;

import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;

import bootcamp.com.bc_yahoo_finance.model.Base;
import bootcamp.com.bc_yahoo_finance.model.Candle;
import bootcamp.com.bc_yahoo_finance.model.PriceLine;
import bootcamp.com.bc_yahoo_finance.model.Transaction;

@Service
public interface TransactionService {
  List<Transaction> getTransactionsOnSysdate(String symbol)
      throws JsonProcessingException;

  PriceLine<Base> get5MinBase(String symbol) throws JsonProcessingException;

  PriceLine<Candle> get5MinCandle(String symbol) throws JsonProcessingException;
}