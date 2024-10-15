package com.bootcamp.bc_calculator.calculatorController;

import java.math.BigDecimal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;

import com.bootcamp.bc_calculator.calculatorService.Impl.CalculatorService;
import com.bootcamp.bc_calculator.model.CalculateResponse;

import lombok.Getter;

@RestController

public class CalculatorController implements CalculatorOperation{

  @Autowired
  private CalculatorService calculatorService;

  @Override
  public CalculateResponse calculate(String x, String y, String operation) {
   return calculatorService.calculate(//
            BigDecimal.valueOf(Long.valueOf(x)), //
            BigDecimal.valueOf(Long.valueOf(y)), //
            operation);

  }

  @Override
  public CalculateResponse calculate2(String x, String y, String operastion) {
  return calculatorService.calculate(
    BigDecimal.valueOf(Long.valueOf(x)),
     BigDecimal.valueOf(Long.valueOf(y)),
     operastion) ;
  }
  
  
}
