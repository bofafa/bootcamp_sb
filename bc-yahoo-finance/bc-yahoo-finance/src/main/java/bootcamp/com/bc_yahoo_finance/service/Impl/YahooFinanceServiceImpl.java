package bootcamp.com.bc_yahoo_finance.service.Impl;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import bootcamp.com.bc_yahoo_finance.entity.StockEntity;
import bootcamp.com.bc_yahoo_finance.entity.StockPriceEntity;
import bootcamp.com.bc_yahoo_finance.exception.BusinessException;
import bootcamp.com.bc_yahoo_finance.exception.ErrorCode;
import bootcamp.com.bc_yahoo_finance.infra.yahoo.YHRestClient;
import bootcamp.com.bc_yahoo_finance.mapper.StockMapper;
import bootcamp.com.bc_yahoo_finance.mapper.StockPriceMapper;
import bootcamp.com.bc_yahoo_finance.model.Stock;

import bootcamp.com.bc_yahoo_finance.model.dto.YahooQuoteDTO;
import bootcamp.com.bc_yahoo_finance.repository.StockPriceRepository;
import bootcamp.com.bc_yahoo_finance.repository.StockRepository;
import bootcamp.com.bc_yahoo_finance.service.YahooFinanceService;


@Service
public class YahooFinanceServiceImpl implements YahooFinanceService {
  @Autowired
  private YHRestClient yahooRestClient;

  @Override
  public YahooQuoteDTO getQuote(List<String> symbols) throws JsonProcessingException {
    return yahooRestClient.getQuote(symbols);
  }
}