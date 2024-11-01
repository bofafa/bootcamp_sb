package bootcamp.com.bc_yahoo_finance.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import bootcamp.com.bc_yahoo_finance.entity.StockPriceEntity;


public interface StockPriceRepository extends JpaRepository <StockPriceEntity, Long>{

  

  
}
