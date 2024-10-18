package com.bootcamp.demo_post.exception;

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
