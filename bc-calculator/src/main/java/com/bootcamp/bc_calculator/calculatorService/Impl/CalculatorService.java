package com.bootcamp.bc_calculator.calculatorService.Impl;

import java.math.BigDecimal;

import com.bootcamp.bc_calculator.model.CalculateResponse;

public interface CalculatorService {
  CalculateResponse calculate (BigDecimal x, BigDecimal y, String operatrion);
  CalculateResponse calculate2 (BigDecimal x, BigDecimal y, String operatrion);
}
