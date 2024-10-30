package bootcamp.com.bc_yahoo_finance.config;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpResponse;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import bootcamp.com.bc_yahoo_finance.entity.TStockEntity;
import bootcamp.com.bc_yahoo_finance.infra.yahoo.CookieManager;
import bootcamp.com.bc_yahoo_finance.infra.yahoo.CrumbManager;
import bootcamp.com.bc_yahoo_finance.infra.yahoo.YHRestClient;
import bootcamp.com.bc_yahoo_finance.model.TStockDTO;
import bootcamp.com.bc_yahoo_finance.repository.StockRepository;
import bootcamp.com.bc_yahoo_finance.service.TStockService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class AppStartRunner implements CommandLineRunner {

        @Autowired
        private StockRepository stockRepository;

        @Autowired
        private CookieManager cookieManager;

        @Autowired
        private CrumbManager crumbManager;

        @Autowired
        private YHRestClient yhRestClient; // Add YHRestClient to fetch stock data

        @Autowired
        private TStockService tStockService;

        @Override
        public void run(String... args) throws Exception {
                // Fetch the stock symbols and save them to the database
                List<TStockEntity> stockSymbols = List.of(
                                new TStockEntity("0388.HK"),
                                new TStockEntity("0700.HK"),
                                new TStockEntity("0005.HK"));

                System.out.println("Stock symbols saved to the database.");

                // Retrieve all stock symbols from the repository
                List<String> symbolList = stockSymbols
                                .stream()
                                .map(TStockEntity::getSymbol)
                                .collect(Collectors.toList());
                System.out.println("symbolList : " + symbolList);
                // Fetch StockDTOs using YHRestClient
                List<String> apiresponse = yhRestClient.fetchStockListResponse(symbolList);

                // System.out.println("apiresponse : " + apiresponse);

                this.tStockService.saveAll(stockSymbols);
                this.tStockService.getAll();

        }
}
