package com.bootcamp.demo.demo_sb_restapi.controller.impl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.bootcamp.demo.demo_sb_restapi.controller.JPHOperation;
import com.bootcamp.demo.demo_sb_restapi.entity.UserEntity;
import com.bootcamp.demo.demo_sb_restapi.model.dto.jph.UserDTO;
import com.bootcamp.demo.demo_sb_restapi.service.JPHService;
import com.bootcamp.demo.demo_sb_restapi.service.impl.JPHServiceImpl;

// A new Thread
// JPHController c = get bean from Context
// c.getUsers();

@RestController
public class JPHController implements JPHOperation {
  private static String x = "abc";
  // Controller Layer -> Service Layer
  // ! Autowired (Bean Injection - from Spring Context)
  // Before Server start:
  // Spring check if there is a bean from Spring Context can be injected into
  // this object reference
  // What if not found ? Server start fail ....
  // After Server start:
  // API request comes... jphController Bean calls jphService Bean
  // @Autowired(required = false)
  // If the bean not found, still proceed server starts ...
  @Autowired
  private JPHService jphService; // Interface
  // Animal animal = new Cat();

  @Override
  public List<UserDTO> getUsers() {
    return this.jphService.getUsers();
  }

  @Override
  public List<UserEntity> createUsers() {
    return this.jphService.saveUsers();
  }

  @Override
  public Boolean deleteUser(Long id) {
    return this.jphService.deleteUser(id); // Junit ?
  }

  @Override
  public UserEntity updateUser(Long id, UserEntity entity) {
    return this.jphService.updateUser(id, entity);
  }

  @Override
  public UserEntity patchUserWebsite(Long id, String website) {
    return this.jphService.patchUserWebsite(id, website);
  }

  @Override
  public UserEntity createUser(UserEntity userEntity) {
    return this.jphService.createUser(userEntity);
  }

  @Override
  public UserEntity getUserByWebsite(String website) {
    return this.jphService.findByWebsite(website).orElse(null);
  }

}
