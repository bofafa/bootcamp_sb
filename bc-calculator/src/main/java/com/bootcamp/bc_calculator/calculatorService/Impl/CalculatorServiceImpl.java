package com.bootcamp.bc_calculator.calculatorService.Impl;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.bootcamp.bc_calculator.calculatorException.CalculatorException;
import com.bootcamp.bc_calculator.model.CalculateResponse;
import com.bootcamp.bc_calculator.model.Operation;

@Service
public class CalculatorServiceImpl implements CalculatorService {

  @Override
  public CalculateResponse calculate(BigDecimal x, BigDecimal y,
  String operation) {
        Operation operator = this.map(operation);
    return CalculateResponse.builder()//
        .x(String.valueOf(x))//
        .y(String.valueOf(y))//
        .operation(operator.name())//
        .result(operator.calculate(x, y))//
        .build();
  }

  @Override
  public CalculateResponse calculate2(BigDecimal x, BigDecimal y,
  String operation) {
    Operation operator = this.map(operation);

    return CalculateResponse.builder()//
        .x(String.valueOf(x))//
        .y(String.valueOf(y))//
        .operation(operator.name())//
        .result(operator.calculate(x, y))//
        .build();
  }
  // String -> Operation.valueOf(operation) -> fit Operation attribute

  private Operation map(String operation) {

    for (Operation op : Operation.values()) {
      if (op.getOperator().equals(operation)) {
        return op;
      }
    }
    throw new CalculatorException("Illegal input operator");
  }

}