package com.bootcamp.demo_jph.exception;

import org.springframework.web.client.RestClientException;

public class JPHRestClientException extends RestClientException {
  public JPHRestClientException(String msg) {
    super(msg);
  }
}

