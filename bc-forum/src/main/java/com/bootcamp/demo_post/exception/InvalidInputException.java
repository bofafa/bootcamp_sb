package com.bootcamp.demo_post.exception;

import org.springframework.web.client.RestClientException;

import lombok.Getter;


@Getter
public class InvalidInputException extends NumberFormatException {
  private final ErrorCode errorCode;

  
  public InvalidInputException(ErrorCode errorCode) {
      super(errorCode.getMessage());
      this.errorCode = errorCode;
  }

  public ErrorCode getErrorCode() {
    return errorCode;
}
}
