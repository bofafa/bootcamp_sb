package com.bootcamp.demo.demo_sb_restapi.exception;

import org.springframework.web.client.RestClientException;

public class JPHRestClientException extends RestClientException {
  public JPHRestClientException(String msg) {
    super(msg);
  }
}
