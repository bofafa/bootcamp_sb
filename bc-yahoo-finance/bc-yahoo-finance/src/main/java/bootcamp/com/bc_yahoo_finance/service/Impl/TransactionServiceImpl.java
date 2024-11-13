package bootcamp.com.bc_yahoo_finance.service.Impl;

import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneOffset;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.JsonProcessingException;

import bootcamp.com.bc_yahoo_finance.entity.StockEntity;
import bootcamp.com.bc_yahoo_finance.mapper.PriceLineMapper;
import bootcamp.com.bc_yahoo_finance.model.Base;
import bootcamp.com.bc_yahoo_finance.model.Candle;
import bootcamp.com.bc_yahoo_finance.model.PriceLine;
import bootcamp.com.bc_yahoo_finance.model.PriceLineProcessor;
import bootcamp.com.bc_yahoo_finance.model.Transaction;
import bootcamp.com.bc_yahoo_finance.model.PriceLine.LineType;
import bootcamp.com.bc_yahoo_finance.repository.TransactionRepository;
import bootcamp.com.bc_yahoo_finance.service.StockService;
import bootcamp.com.bc_yahoo_finance.service.SystemService;
import bootcamp.com.bc_yahoo_finance.service.TransactionService;


@Service
public class TransactionServiceImpl implements TransactionService {
  @Autowired
  private TransactionRepository stockPriceRepository;
  @Autowired
  private StockService stockService;
  @Autowired
  private SystemService systemService;
  @Autowired
  private PriceLineMapper priceLineMapper;

  @Override
  public List<Transaction> getTransactionsOnSysdate(String symbol)
      throws JsonProcessingException {
    // ! Get Sysdate by symbol
    LocalDate sysDate = systemService.getSysDate(symbol);
    // ! Convert the LocalDate to StartTime and EndTime
    long startEpoch = sysDate.atStartOfDay() //
        .toEpochSecond(ZoneOffset.UTC);
    long endEpoch = sysDate.atTime(LocalTime.MAX) //
        .toEpochSecond(ZoneOffset.UTC);
    // ! Get all Transactions by symbol and sysDate
    return this.stockPriceRepository.findBySymbol(symbol, startEpoch, endEpoch)
        .stream() //
        .map(e -> this.priceLineMapper.map(e)) //
        .collect(Collectors.toList());
  }

  @Override
  public PriceLine<Base> get5MinBase(String symbol)
      throws JsonProcessingException {
    List<Transaction> transactions = getTransactionsOnSysdate(symbol);
    StockEntity stockEntity = this.stockService.findBySymbol(symbol);
    return PriceLineProcessor.of(LineType.MIN5, stockEntity.getId(),
        stockEntity.getSymbol(), transactions).getBaseLine(5);
  }

  @Override
  public PriceLine<Candle> get5MinCandle(String symbol)
      throws JsonProcessingException {
    List<Transaction> transactions = getTransactionsOnSysdate(symbol);
    StockEntity stockEntity = this.stockService.findBySymbol(symbol);
    return PriceLineProcessor.of(LineType.MIN5, stockEntity.getId(),
        stockEntity.getSymbol(), transactions).getCandleLine(5);
  }
}