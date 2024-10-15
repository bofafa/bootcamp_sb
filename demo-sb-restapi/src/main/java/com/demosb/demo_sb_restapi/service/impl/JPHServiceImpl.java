package com.demosb.demo_sb_restapi.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.demosb.demo_sb_restapi.dto.user;
import com.demosb.demo_sb_restapi.entity.UserEntity;
import com.demosb.demo_sb_restapi.exception.JPHRestClientException;
import com.demosb.demo_sb_restapi.mapper.JPHMapper;
import com.demosb.demo_sb_restapi.model.Cat;
import com.demosb.demo_sb_restapi.responsitory.UserRepository;
import com.demosb.demo_sb_restapi.service.JPHService;
import com.demosb.demo_sb_restapi.util.Scheme;
import com.demosb.demo_sb_restapi.util.Url;

@Service // Component annotation -> bean
public class JPHServiceImpl implements JPHService {
  @Autowired
  @Qualifier(value = "JPHRestTemplate") // inject bean by speicifc bean name
  private RestTemplate restTemplate;

  @Autowired
  private Cat cat; // Vincent

  @Autowired
  private UserRepository userRepository;

  @Autowired
  private JPHMapper jphMapper;

  // ! @Value (inject from yml) is similar to @Autowired (inject from Spring
  // Context)
  // Both of them has to be executed before server start
  @Value("${api.jph.domain}")
  private String jphDomain;

  @Value("${api.jph.endpoints.users}")
  private String usersEndpoint;

  @Override
  public List<user> getUsers() {
    // ! You can use UriComponentBuilder directly
    String url = Url.builder() //
        .scheme(Scheme.HTTPS) //
        .domain(this.jphDomain) //
        .endpoint(this.usersEndpoint) //
        .build() //
        .toUriString();
    System.out.println("url=" + url);
    user[] users;
    try{
      users = this.restTemplate.getForObject(url, user[].class);
    }catch (RestClientException e) {
      throw new JPHRestClientException ("joson Placeholder exception.");
    }
    return List.of(users);
  }

  @Override
  public List<UserEntity> saveUsers() {
    // Call External JPH service
    List<user> users = this.getUsers();
    return this.saveUsers(users);
  }

  private List<UserEntity> saveUsers(List<user> users) {
    // Mapper: from List<user> to List<UserEntity>
    List<UserEntity> userEntities = users.stream() //
        .map(e -> this.jphMapper.map(e)) //
        .collect(Collectors.toList());
    return userRepository.saveAll(userEntities);
  }

  // saveUser(int id)
  // -> stream filter -> save()
}