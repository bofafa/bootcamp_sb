package bootcamp.com.bc_yahoo_finance.controller;
import java.util.List;
import java.io.IOException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.fasterxml.jackson.core.JsonProcessingException;

import bootcamp.com.bc_yahoo_finance.model.dto.YahooQuoteDTO;

public interface YahooFinanceOperation {
 

  @GetMapping ("/yahoo/qoute")
 public YahooQuoteDTO getQuote (@RequestParam List<String> symbols)throws JsonProcessingException;
}


 // http://localhost:8083/v1/yahoo/quote?symbols=0388.HK,0700.HK