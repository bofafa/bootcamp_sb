package bootcamp.com.bc_yahoo_finance.service;

import java.util.List;

import com.fasterxml.jackson.core.JsonProcessingException;

import bootcamp.com.bc_yahoo_finance.model.dto.YahooQuoteDTO;

public interface YahooFinanceService {
  YahooQuoteDTO getQuote(List<String> symbols) throws JsonProcessingException;
}