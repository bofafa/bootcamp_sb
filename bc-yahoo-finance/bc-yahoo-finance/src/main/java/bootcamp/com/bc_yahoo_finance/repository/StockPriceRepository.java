package bootcamp.com.bc_yahoo_finance.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import bootcamp.com.bc_yahoo_finance.entity.StockPriceEntity;


@Repository
public interface StockPriceRepository extends JpaRepository<StockPriceEntity, Long> {

  List<StockPriceEntity> findBySymbol(String symbol);

    
        // // Custom query to fetch all stock prices for a given symbol
        // @Query("SELECT s FROM StockPriceEntity s WHERE s.symbol = :symbol ORDER BY s.tranDatetime DESC")
        // List<StockPriceEntity> findBySymbol(String symbol);
    

    // // Fetch the latest stock price for a given symbol (optional)
    // Optional<StockPriceEntity> findTopBySymbolOrderByTranDatetimeDesc(String symbol);
}