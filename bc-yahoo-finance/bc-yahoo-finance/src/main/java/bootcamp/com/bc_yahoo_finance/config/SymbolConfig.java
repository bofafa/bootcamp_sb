package bootcamp.com.bc_yahoo_finance.config;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import bootcamp.com.bc_yahoo_finance.entity.StockEntity;
import bootcamp.com.bc_yahoo_finance.entity.StockPriceEntity;
import bootcamp.com.bc_yahoo_finance.repository.StockPriceRepository;
import bootcamp.com.bc_yahoo_finance.repository.StockRepository;
import bootcamp.com.bc_yahoo_finance.service.StockService;
import bootcamp.com.bc_yahoo_finance.service.YahooFinanceService;

@Component
public class SymbolConfig implements CommandLineRunner {
  @Autowired
  private StockService stockService;
  @Autowired
  private StockRepository stockRepository;
  @Autowired
  private StockPriceRepository stockPriceRepository;

  /**
   * For System Design, there should be admin system for stock symbols setup. In
   * case new stock launch in HKEX, our system control the right to support the
   * new symbol.
   * 
   * The admin system should insert, update & delete the stock list. So, this
   * SymbolConfig.class is just for exercise/ testing purpose.
   */
  @Override
  public void run(String... args) {
    // ! Clear all Stock Symbols in DB. (jpa.hibernate.ddl-auto: update)
    // For retrun process.
    //this.stockPriceRepository.deleteAll();
    this.stockRepository.deleteAll();

    String[] symbols = new String[] {"0388.HK", "0700.HK", "0005.HK"};
    List<StockEntity> entities = Arrays.stream(symbols) //
        .map(e -> StockEntity.builder().symbol(e).build()) //
        .collect(Collectors.toList());
    stockService.saveAll(entities);
    System.out.println("Insert Stock Symbols Completed.");

    System.out.println("6A getDate*********" + stockService.getMaxDay("0700.HK"));
  }
}