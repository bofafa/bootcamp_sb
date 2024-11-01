package bootcamp.com.bc_yahoo_finance.exception;

import bootcamp.com.bc_yahoo_finance.model.dto.YahooQuoteErrorDTO;

public class StockQuoteYahooException extends BusinessException {
  public StockQuoteYahooException(YahooQuoteErrorDTO quoteErrorDTO) {
    super(ErrorCode.RESST_TEMPLAT_ERROR,
        quoteErrorDTO.getBody().getError().getMessage());
  }
}
