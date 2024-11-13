package bootcamp.com.bc_yahoo_finance.model;



import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class Candle extends PriceType {
  private double open;
  private double close;
  private double high;
  private double low;
}