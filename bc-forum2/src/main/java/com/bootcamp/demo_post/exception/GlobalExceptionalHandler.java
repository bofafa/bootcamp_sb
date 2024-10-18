package com.bootcamp.demo_post.exception;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.client.RestClientException;
@RestControllerAdvice
public class GlobalExceptionalHandler {
  
  @ExceptionHandler ({RestClientException.class})    // RestClientException -> springboot class
  @ResponseStatus(value = HttpStatus.BAD_REQUEST)    //開新class ErrorResponse for exception 要有乜， 有code + message), BAD_REQUEST -> type of error
    public ErrorResponse handlerestClientExceptionHandler() {
    return ErrorResponse.builder()           
   .code(ErrorCode.BAD_REQUEST.getCode())           // dot 返enum 出嚟
   .message(ErrorCode.BAD_REQUEST.getMessage())
   .build();
  }


  @ExceptionHandler({JPHRestClientException.class})
  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
  public ErrorResponse jphRestClientExceptionHandler() {
    return ErrorResponse.builder()           
    .code(ErrorCode.JASON_PLACEHOLDER_ERROR.getCode())
    .message(ErrorCode.JASON_PLACEHOLDER_ERROR.getMessage())
    .build();
  }


  @ExceptionHandler(UserNotFoundException.class)      //自己寫嘅 user not found exception class
  @ResponseStatus(value = HttpStatus.NOT_FOUND)
  public ErrorResponse handleUserNotFoundException(){        
    return ErrorResponse.builder()                            // return 返俾error Response，用builder pattern 裝reponse
  .code(ErrorCode.USER_NOT_FOUND.getCode())
  .message(ErrorCode.USER_NOT_FOUND.getMessage())
  .build();
 }

  @ExceptionHandler(NumberFormatException.class)       //最底層Run time error: NumberFormatException
  @ResponseStatus(value = HttpStatus.NOT_ACCEPTABLE)
  public ErrorResponse handleInvalidInputException() {    // 用自己嘅包裝 handleInvalidInputException，number format error
      return ErrorResponse.builder()
      .code(ErrorCode.INVALID_INPUT.getCode())
      .message(ErrorCode.INVALID_INPUT.getMessage())
      .build();
  }

  @ExceptionHandler(RestTemplateException.class)       //自己寫嘅 rest Template Excaption
  @ResponseStatus(value = HttpStatus.SERVICE_UNAVAILABLE)
  public ErrorResponse handleRestTemplateException() {
      return ErrorResponse.builder()//
      .code(ErrorCode.RESST_TEMPLAT_ERROR.getCode())//
      .message(ErrorCode.RESST_TEMPLAT_ERROR.getMessage())//
      .build();
  }



    //  @ExceptionHandler(UserNotFoundException.class)
    //  @ResponseStatus(value = HttpStatus.BAD_REQUEST)
    // public ResponseEntity<Map <String, Object>> handleUserNotFoundException(UserNotFoundException ex) {
    //     Map<String, Object> response = new HashMap<>();
    //     response.put("code", 1);
    //     response.put("message", ex.getMessage());

    //     return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    // }

    // // Handle other exceptions (optional)
    // @ExceptionHandler(Exception.class)
    // public ResponseEntity<Map<String, Object>> handleGeneralException(Exception ex) {
    //     Map<String, Object> response = new HashMap<>();
    //     response.put("code", 2);
    //     response.put("message", "Invalid Input");

    //     return new ResponseEntity<>(response, HttpStatus.NOT_ACCEPTABLE);
    // }
}


