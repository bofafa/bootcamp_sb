package bootcamp.com.bc_yahoo_finance.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import bootcamp.com.bc_yahoo_finance.entity.TStockEntity;

@Repository
public interface StockRepository extends JpaRepository<TStockEntity, Long>{
  
}
