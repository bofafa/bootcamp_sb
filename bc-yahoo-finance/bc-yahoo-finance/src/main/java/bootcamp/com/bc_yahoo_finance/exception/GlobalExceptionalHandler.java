package bootcamp.com.bc_yahoo_finance.exception;

import java.io.IOException;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

// @RestControllerAdvice
public class GlobalExceptionalHandler {

  @ExceptionHandler(RestTemplateException.class) // 自己寫嘅 rest Template Excaption
  @ResponseStatus(value = HttpStatus.SERVICE_UNAVAILABLE)
  public ErrorResponse handleRestTemplateException() {
    return ErrorResponse.builder()//
        .code(ErrorCode.RESST_TEMPLAT_ERROR.getCode())
        .message(ErrorCode.RESST_TEMPLAT_ERROR.getMessage())//
        .build();
  }

  @ExceptionHandler(IOException.class)
  @ResponseStatus(value = HttpStatus.SERVICE_UNAVAILABLE)
  public ErrorResponse handleIOException() {
    return ErrorResponse.builder()//
        .code(ErrorCode.RESST_TEMPLAT_ERROR.getCode())//
        .message(ErrorCode.RESST_TEMPLAT_ERROR.getMessage())//
        .build();
  }

  @ExceptionHandler(JsonProcessingException.class)
  @ResponseStatus(value = HttpStatus.SERVICE_UNAVAILABLE)
  public ErrorResponse handleJsonProcessingExceptionJava() {
    return ErrorResponse.builder()//
        .code(ErrorCode.RESST_TEMPLAT_ERROR.getCode())//
        .message(ErrorCode.RESST_TEMPLAT_ERROR.getMessage())//
        .build();
  }

  @ExceptionHandler(JsonMappingException.class)
  @ResponseStatus(value = HttpStatus.SERVICE_UNAVAILABLE)
  public ErrorResponse handleJsonMappingException() {
    return ErrorResponse.builder()//
        .code(ErrorCode.RESST_TEMPLAT_ERROR.getCode())//
        .message(ErrorCode.RESST_TEMPLAT_ERROR.getMessage())//
        .build();
  }

  @ExceptionHandler(RuntimeException.class)
  @ResponseStatus(value = HttpStatus.SERVICE_UNAVAILABLE)
  public ErrorResponse handleRuntimeException() {
    return ErrorResponse.builder()//
        .code(ErrorCode.RESST_TEMPLAT_ERROR.getCode())//
        .message(ErrorCode.RESST_TEMPLAT_ERROR.getMessage())//
        .build();
  }

  @ExceptionHandler(Exception.class)
  @ResponseStatus(value = HttpStatus.SERVICE_UNAVAILABLE)
  public ErrorResponse handleException() {
    return ErrorResponse.builder()//
        .code(ErrorCode.RESST_TEMPLAT_ERROR.getCode())//
        .message(ErrorCode.RESST_TEMPLAT_ERROR.getMessage())//
        .build();
  }


}
