package com.bootcamp.bc_calculator.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

import com.bootcamp.bc_calculator.calculatorException.CanNotBeZeroException;
import com.bootcamp.bc_calculator.calculatorException.InvalidOperatorException;

import lombok.Getter;

@Getter
public enum Operation {
  ADD("add"),
  SUBTRACT ("sub"),
  MULTIPLY ("mul"),
  DIVIDE ("div"),
  ;

  private String operator; // 

  private Operation (String operator){
    this.operator = operator;
  }

  public String calculate (BigDecimal x, BigDecimal y ){
    return switch (this){
     case ADD-> x.add(y).setScale(5).toString();
     case SUBTRACT -> x.subtract(y).setScale(5).toString();
     case MULTIPLY -> x.multiply(y).setScale(5).toString();
     case DIVIDE -> {
      if (y.equals(BigDecimal.ZERO)){
        throw new CanNotBeZeroException ("y can not be zero");
      }yield x.divide(y,5, RoundingMode.HALF_UP).toString();
    }
    default -> throw new InvalidOperatorException("must input + - * / operator");
    
     };

    }
  }

