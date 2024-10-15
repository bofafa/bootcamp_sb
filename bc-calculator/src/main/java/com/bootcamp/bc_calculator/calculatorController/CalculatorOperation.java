package com.bootcamp.bc_calculator.calculatorController;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.bootcamp.bc_calculator.model.CalculateResponse;

public interface CalculatorOperation {

  @GetMapping ("/operation")
  CalculateResponse calculate (@RequestParam String x, 
  @RequestParam String y,
  @RequestParam String operation);
  
  @GetMapping ("/operation/{x}/{y}")
  CalculateResponse calculate2 (@PathVariable String x,
  @PathVariable String y,
  @PathVariable String operastion);
  


}
