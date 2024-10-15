package com.demosb.demo_sb_restapi.controller.impl;

import java.util.List;

import org.springframework.web.bind.annotation.RestController;

import com.demosb.demo_sb_restapi.DemoSbRestapiApplication;
import com.demosb.demo_sb_restapi.controller.BeanOperation;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
public class BeanController implements BeanOperation {

  private int x = 10;

@Override
public int getX(){
  return this.x;
}


  @Override
  public List <String> getBeans(){
    return List.of(DemoSbRestapiApplication.context.getBeanDefinitionNames());
    
  }
  
}
