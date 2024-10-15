package com.bootcamp.demo_post.exception;

import org.springframework.web.client.RestClientException;

public class JPHRestClientException extends RestClientException {
  public JPHRestClientException (String message){
    super(message);
  }
}
