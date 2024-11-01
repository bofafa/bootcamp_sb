package bootcamp.com.bc_yahoo_finance.exception;

public class RestTemplateException extends RuntimeException {
  private final ErrorCode errorCode;

  public RestTemplateException(ErrorCode errorCode){
    super(errorCode.getMessage());
    this.errorCode = errorCode;
  }

  public ErrorCode getErrorCode() {
    return errorCode;
}
}
