package bootcamp.com.bc_yahoo_finance.exception;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Builder
@Getter
public class ErrorResponse {
  private int code;
  private String message;
}
