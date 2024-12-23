package bootcamp.com.bc_yahoo_finance.model;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@AllArgsConstructor
@ToString
public class Transaction {
  private LocalDateTime dateTime;
  private double price;

  public Transaction(long epochSecond, double price) {
    this.dateTime = LocalDateTime.ofInstant(Instant.ofEpochSecond(epochSecond),
        ZoneOffset.UTC);
    this.price = price;
  }
}