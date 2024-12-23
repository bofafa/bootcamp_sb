package bootcamp.com.bc_yahoo_finance.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;


@Getter
@Builder
@AllArgsConstructor
@ToString
public class Base extends PriceType {
  private double close;
}