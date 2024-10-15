package com.bootcamp.demo_post.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.RestClientException;
@RestControllerAdvice
public class GlobalExceptionalHandler {
  
  @ExceptionHandler ({RestClientException.class})
  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
   public String restClientExceptionHandler() {
    return "Service Unavailable. Please try again later.";
  }

  @ExceptionHandler({JPHRestClientException.class})
  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
  public String jphRestClientExceptionHandler() {
    return "Json Placeholder Service Unavailable. Please try again later.";
  }

}
