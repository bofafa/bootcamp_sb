package com.demosb.demo_sb_restapi.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;

public interface BeanOperation {
  @GetMapping(value ="/beans")
  List<String> getBeans();

  @GetMapping(value = "/beans/x")
  int getX();
}
