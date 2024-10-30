package com.bootcamp.demo.demo_sb_restapi.util;

import java.util.ArrayList;
import java.util.List;
import com.bootcamp.demo.demo_sb_restapi.model.dto.jph.UserDTO;

public class ApiResp<T> {
  private String code;
  private String message;
  private List<T> data; //

  public String getCode() {
    return this.code;
  }

  public String getMessage() {
    return this.message;
  }

  public List<T> getData() {
    return this.data;
  }

  public ApiResp(Builder<T> builder) {
    this.code = builder.code;
    this.message = builder.message;
    this.data = builder.data;
  }

  public static <U> Builder<U> builder() {
    return new Builder<>();
  }

  public static class Builder<T> {
    private String code;
    private String message;
    private List<T> data;

    public Builder<T> code(String code) {
      this.code = code;
      return this;
    }

    public Builder<T> message(String message) {
      this.message = message;
      return this;
    }

    public Builder<T> data(List<T> data) {
      this.data = data;
      return this;
    }

    public ApiResp<T> build() {
      return new ApiResp<>(this);
    }
  }

  public static void main(String[] args) {
    // !
    ApiResp<UserDTO> response = ApiResp.<UserDTO>builder() //
        .code("000000") //
        .message("Success.") //
        .build();

    // Controller Layer -> return ApiResp<>
    // Global Exception Handler -> return ApiResp<>

    // enum SysCode for Api Response use.
    // enum ErrorCode for error only

    List<String> strings = new ArrayList<>(); // after Java 1.5
  }
}
