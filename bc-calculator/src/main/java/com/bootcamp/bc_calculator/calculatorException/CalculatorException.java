package com.bootcamp.bc_calculator.calculatorException;

import lombok.Getter;

@Getter
public class CalculatorException extends IllegalArgumentException {
  private String message;

  public CalculatorException (String message){
    this.message = message;
  }
  
}
