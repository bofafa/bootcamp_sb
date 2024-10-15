// package com.demosb.demo_sb_restapi.service.impl;

// import java.util.List;

// import org.springframework.context.annotation.Primary;
// import org.springframework.stereotype.Service;
// import org.springframework.web.client.RestTemplate;

// import com.demosb.demo_sb_restapi.dto.user;
// import com.demosb.demo_sb_restapi.service.JPHService;


// @Service // Component annotation -> bean 
// @Primary
// public class JPHServiceImpl2 implements JPHService {
//   @Override
//   public List<user> getUsers() {
//     user[] users = new RestTemplate().getForObject(
//         "https://jsonplaceholder.typicode.com/users", user[].class);
//     return List.of(users);
//   }
// }

// //  RestTemplate 