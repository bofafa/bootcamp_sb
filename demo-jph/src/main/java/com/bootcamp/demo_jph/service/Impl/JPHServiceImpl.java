package com.bootcamp.demo_jph.service.Impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.bootcamp.demo_jph.dto.UserDTO;
import com.bootcamp.demo_jph.entity.UserEntity;
import com.bootcamp.demo_jph.exception.JPHRestClientException;
import com.bootcamp.demo_jph.mapper.JPHMapper;
import com.bootcamp.demo_jph.repository.UserRepository;
import com.bootcamp.demo_jph.service.JPHService;
import com.bootcamp.demo_jph.util.Scheme;
import com.bootcamp.demo_jph.util.Url;



@Service // Component annotation -> bean
public class JPHServiceImpl implements JPHService {
  @Autowired
  @Qualifier(value = "JPHRestTemplate") // inject bean by speicifc bean name
  private RestTemplate restTemplate;


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
  public List<UserDTO> getUsers() {
    // ! You can use UriComponentBuilder directly
    String url = Url.builder() //
        .scheme(Scheme.HTTPS) //
        .domain(this.jphDomain) //
        .endpoint(this.usersEndpoint) //
        .build() //
        .toUriString();
    System.out.println("url=" + url);
    UserDTO[] users;
    try{
      users = this.restTemplate.getForObject(url, UserDTO[].class);
    }catch (RestClientException e) {
      throw new JPHRestClientException ("joson Placeholder exception.");
    }
    return List.of(users);
  }

  @Override
  public List<UserEntity> saveUsers() {
    // Call External JPH service
    List<UserDTO> userDTOs = this.getUsers();
    return this.saveUsers(userDTOs);
  }

  private List<UserEntity> saveUsers(List<UserDTO> userDTOs) {
    // Mapper: from List<UserDTO> to List<UserEntity>
    List<UserEntity> userEntities = userDTOs.stream() //
        .map(e -> this.jphMapper.map(e)) //
        .collect(Collectors.toList());
    return userRepository.saveAll(userEntities);
  }

  // saveUser(int id)
  // -> stream filter -> save()
}