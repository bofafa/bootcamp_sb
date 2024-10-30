package com.bootcamp.demo.demo_sb_restapi;

import static org.hamcrest.Matchers.hasItem;
import static org.hamcrest.Matchers.is;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.hamcrest.MatcherAssert.assertThat;
import java.util.Arrays;
import java.util.List;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;
import com.bootcamp.demo.demo_sb_restapi.controller.impl.JPHController;
import com.bootcamp.demo.demo_sb_restapi.model.dto.jph.UserDTO;
import com.bootcamp.demo.demo_sb_restapi.service.JPHService;
import com.fasterxml.jackson.databind.ObjectMapper;

// ! Test Controller ONLY
@WebMvcTest(JPHController.class) // ~ Include Controller bean only
class JPHControllerTest {
  // ! WebMvcTest -> MockMvc -> Call Controller Endpoints
  // Validate functionality of endpoints, similar to Postman

  // ! How to use Postman for testing?
  // 1. "mvn spring-boot:run"
  // 2. Must be Integration Test

  @MockBean // because main code using Autowired for the bean object
  private JPHService jphService;

  @Autowired
  private MockMvc mockMvc; // simliar to postman, for testing only
  // ! In real spring env, NO MockMvc bean.

  @Test
  void testJPHGetAllUsers() throws Exception {
    // Mock Result
    UserDTO user1 = UserDTO.builder() //
        .username("vincentlau") //
        .website("vincentlau@gmail.com") //
        .phone("12345678") //
        .build();

    UserDTO user2 = UserDTO.builder() //
        .username("jennyshe") //
        .website("jennyshe@gmail.com") //
        .phone("23456789") //
        .build();

    // Define how the Result is being mocked
    Mockito.when(jphService.getUsers()).thenReturn(List.of(user1, user2));

    // ! Test Web Layer to call controller
    // ! Approach 1
    mockMvc.perform(get("/jph/users"))
        .andExpect(jsonPath("$[0].username", is("vincentlau")))
        .andExpect(jsonPath("$[0].website", is("vincentlau@gmail.com")))
        .andExpect(jsonPath("$[1].username", is("jennyshe")))
        .andExpect(jsonPath("$[1].website", is("jennyshe@gmail.com")));

    verify(jphService, times(1)).getUsers();

    // ! Approach 2
    mockMvc.perform(get("/jph/users"))
        .andExpect(jsonPath("$[*].username").value(hasItem("vincentlau")))
        .andExpect(
            jsonPath("$[*].website").value(hasItem("vincentlau@gmail.com")))
        .andExpect(jsonPath("$[*].username").value(hasItem("jennyshe")))
        .andExpect(
            jsonPath("$[*].website").value(hasItem("jennyshe@gmail.com")));

    verify(jphService, times(2)).getUsers();

    // ! Approach 3
    String resultJson = mockMvc.perform(get("/jph/users")) //
        .andReturn() //
        .getResponse() //
        .getContentAsString();

    // from Json String to Java object (De-serialization)
    UserDTO[] userDTOs =
        new ObjectMapper().readValue(resultJson, UserDTO[].class);

    // Array to ArrayList
    List<UserDTO> users = Arrays.asList(userDTOs);

    assertThat(users.get(0).getUsername(), is("vincentlau"));
    assertThat(users.get(1).getUsername(), is("jennyshe"));
  }
}
