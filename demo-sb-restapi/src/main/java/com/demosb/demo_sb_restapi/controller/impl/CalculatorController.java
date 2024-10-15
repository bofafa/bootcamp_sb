package com.demosb.demo_sb_restapi.controller.impl;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.experimental.PackagePrivate;

@Controller
@ResponseBody
public class CalculatorController {
  @GetMapping (value = "/sum/{x}/{y}")
  public int sum (@PathVariable int x, @PathVariable int y){
   return (long) x + (long) y >Integer.MAX_VALUE ? -1 : x+y;
  }

    //Ambiguous mapping
  @GetMapping (value = "/subtract/{x}/{y}")
  public int paidAmount (@PathVariable (value="x") int checkoutAmount,
  @PathVariable (value = "y") int discountAmount) {
    return checkoutAmount - discountAmount;
  }


   @GetMapping (value = "/multply/{x}/{y}")
  public int multiply (@PathVariable int x, @PathVariable int y){
    return x * y;
  } 

// 1. divide zero, return "y should be non-zero integer"
//2. if x or y is not integer, them return "x and y should be integer"

  @GetMapping (value = "/divide/ {x}/{y}")
  public String divide (@PathVariable String x, @PathVariable String y){
  try{
    int x1= Integer.parseInt(x);
    int y1= Integer.parseInt(y);
   return String.valueOf(x1/y1);
    } catch (ArithmeticException e){
      return " y should be non-zero integer";
    }catch (NumberFormatException e) {
      return "x and u should be integer.";
    }
 
    
    }
  }
