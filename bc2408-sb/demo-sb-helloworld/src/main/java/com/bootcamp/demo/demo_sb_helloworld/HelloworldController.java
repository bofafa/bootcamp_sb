package com.bootcamp.demo.demo_sb_helloworld;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@ResponseBody
public class HelloworldController {
  
  // endpoint to locate the web service
  // http://127.0.0.1:8080/hello
  // http://localhost:8080/hello
  @GetMapping(value = "/hello")
  public String sayHello() {
    // System.out.println("!!!!!!!!!!!!!");
    return "Hello World!";
  }

}
