package com.bootcamp.demo_post.exception;

import org.springframework.web.client.RestClientException;

public class UserNotFoundException extends RestClientException {
//   public UserNotFoundException (String message){
//     super(message);
// }
private final ErrorCode errorCode;

public UserNotFoundException(ErrorCode errorCode) {
    super(errorCode.getMessage());
    this.errorCode = errorCode;
}

public ErrorCode getErrorCode() {
    return errorCode;
}
}

