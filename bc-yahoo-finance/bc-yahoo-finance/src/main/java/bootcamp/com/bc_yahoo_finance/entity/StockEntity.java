package bootcamp.com.bc_yahoo_finance.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "tstocks")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class StockEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Long id;
  String symbol;
  





  
  //只放 symbol 
  public StockEntity(String symbol){
    this.symbol=symbol;
  }
}
