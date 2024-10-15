package com.bootcamp.demo_jph.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.RestClientException;


// Java: A-> B -> C, if C throw, the state will be back to B
// String: web layer -> Controller -> Service (throw)-> Exception handler ->web layer
// MPE advantages: Null pointer exception

// Advantages: Appropriate for General Exception Handling (i.e MPE)


// By default Catch Child Exception first, then parent exception
@RestControllerAdvice //Inspectpr (Between methods)
public class GlobalExceptionalHandler {
  
  // Spring web layer -> A -> B -> C -> Exception handler -> B
  @ExceptionHandler({RestClientException.class})
  @ResponseStatus(value = HttpStatus.BAD_REQUEST) // 400 http status code
  public String restClientExceptionHandler() {
    return "Service Unavailable. Please try again later.";
  }

  @ExceptionHandler({JPHRestClientException.class})
  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
  public String jphRestClientExceptionHandler() {
    return "Json Placeholder Service Unavailable. Please try again later.";
  }

}