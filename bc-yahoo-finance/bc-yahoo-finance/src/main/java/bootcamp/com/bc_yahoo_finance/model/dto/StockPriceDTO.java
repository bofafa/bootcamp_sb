package bootcamp.com.bc_yahoo_finance.model.dto;


import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Builder
@ToString
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class StockPriceDTO {
    private Long regularMarketTime;
    private List<Data> data;

    @Getter
    @Builder
    @ToString
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Data {
        private String symbol;
        private String marketTime;
        private Long  regularMarketUnix;
        private Double regularMarketPrice;
        private Double regularMarketChangePercent;
    }

}