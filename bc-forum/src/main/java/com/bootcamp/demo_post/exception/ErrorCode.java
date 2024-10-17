package com.bootcamp.demo_post.exception;

import lombok.Getter;
import lombok.Setter;


@Getter
public enum ErrorCode {
  USER_NOT_FOUND(1, "User not Found"),
  INVALID_INPUT(2, "Invalid Input"),
  RESST_TEMPLAT_ERROR(3,"RestTem Error - JsonPlaceHolder"),
  BAD_REQUEST(4, "Service Unavailable. Please try again later."),
  JASON_PLACEHOLDER_ERROR (5, "Json Placeholder Service Unavailable. Please try again later.");

  private final int code;
  private final String message;

  ErrorCode (int code, String message){
    this.code=code;
    this.message=message;
  }
}
