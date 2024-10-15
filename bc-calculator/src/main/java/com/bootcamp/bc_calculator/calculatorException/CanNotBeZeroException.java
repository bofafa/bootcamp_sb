package com.bootcamp.bc_calculator.calculatorException;

import lombok.Getter;

@Getter

public class CanNotBeZeroException extends IllegalArgumentException {
  private String message;
   
  public CanNotBeZeroException(String string) {
    //TODO Auto-generated constructor stub
  }

  public String CanNotBeZeroException (String message){
    return this.message = message;
  }

  }
