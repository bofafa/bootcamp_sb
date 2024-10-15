package com.bootcamp.bc_calculator.calculatorException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.bootcamp.bc_calculator.model.ErrorResponse;

public class GlobalExceptionHandler {
  @ExceptionHandler (CanNotBeZeroException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ErrorResponse cannotDivideZeroException() {
    return ErrorResponse.builder()//
        .code(9)//
        .message("Invalid Input")//
        .build();
  }

  @ExceptionHandler(RuntimeException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ErrorResponse runtimeException() {
    return ErrorResponse.builder()//
        .code(9)//
        .message("RuntimeException ")//
        .build();
  }

  @ExceptionHandler(Exception.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  public ErrorResponse exception() {
    return ErrorResponse.builder()//
        .code(9)//
        .message("Invalid Input")//
        .build();
  }
}