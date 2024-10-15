package com.bootcamp.bc_calculator.calculatorException;

import lombok.Getter;

@Getter
public class  InvalidOperatorException extends IllegalArgumentException {
  private String message;

public InvalidOperatorException (String messsage){
  this.message= message;
}
}
