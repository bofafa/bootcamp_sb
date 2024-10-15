package com.bootcamp.demo_jph;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import java.util.List;

import org.hamcrest.Matchers;

import com.bootcamp.demo_jph.controller.JPHController;
import com.bootcamp.demo_jph.dto.user;
import com.bootcamp.demo_jph.service.JPHService;

//! Test Controller Only
//controller call service, service call responsry
@WebMvcTest(JPHController.class) // webMVCTest -> mockMVC-> call controller Endpoints

// ! how to use Postman for testing?
// 1. mvn spring-bootrun
// 2. must be Integration test
// main 世界無MockMvc

class JPHControllerTest { // test case no need public, its not for calling.

  @MockBean // 等如 Autowired // testing 用//because main code using Autowired for the bean
            // object
  private JPHService jphService;

  @Autowired
  private MockMvc mockMvc; // simliar to postman, for testing only, // In rael spring emv, no MockMvc Bean!

  @Test
  void testJPHGetAllUser() throws Exception{
  
    user user1 = user.builder()
    .username("vincentlau")
    .website("vincentlau@gmail.com")
    .phone("2345678")
    .build();


  user user2 = user.builder()
  .username("jennyshe")
  .website("jennyshe@gmail.com")
  .phone("2345678")
  .build();
  
    Mockito.when(jphService.getUsers()).thenReturn(List.of(user1,user2));

    
  mockMvc.perform(get("/jph/users"))
  .andExpect(jsonPath("$[0].username", Matchers.is("vincentlau")))
  .andExpect(jsonPath("$[0].website", Matchers.is("vincentlau@gmail.com")))
  .andExpect(jsonPath("$[1].username", Matchers.is("jennyshe")));


  verify (jphService, times(1)).getUsers();
}
}
