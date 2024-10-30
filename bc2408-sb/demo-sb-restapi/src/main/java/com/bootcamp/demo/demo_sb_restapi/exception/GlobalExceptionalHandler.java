package com.bootcamp.demo.demo_sb_restapi.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.RestClientException;
import com.bootcamp.demo.demo_sb_restapi.model.Cat;
import org.springframework.http.HttpStatus;

// ! Java: A -> B -> C, if C throw, the state will be back to B.

// ! Spring: Web Layer -> Controller -> Service (throw) -> Exception Hanlder -> Web Layer

// ! Advantages: Appropriate for General Exception Handling (i.e NPE)
// By default Catch Child Exception first, then parent exception
@RestControllerAdvice // Inspector (Between methods)
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
