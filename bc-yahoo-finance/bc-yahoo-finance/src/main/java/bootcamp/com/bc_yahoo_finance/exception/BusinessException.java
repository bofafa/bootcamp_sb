package bootcamp.com.bc_yahoo_finance.exception;

import bootcamp.com.bc_yahoo_finance.infra.web.Errorable;

public class BusinessException extends RuntimeException {
  private int code;

  public BusinessException(Errorable errorCode) {
    super(errorCode.getMessage());
    this.code = errorCode.getCode();
  }

  public BusinessException(Errorable error, String overrideMessage) {
    super(overrideMessage);
    this.code = error.getCode();
  }

  public int getCode() {
    return this.code;
  }
}