package com.bootcamp.demo_jph.service.Impl;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


import org.apache.tomcat.util.http.fileupload.MultipartStream.IllegalBoundaryException;
import org.hibernate.annotations.DialectOverride.OverridesAnnotation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;

import com.bootcamp.demo_jph.dto.user;
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

  @Override
  public Boolean deleteUser(Long id) {
    if (this.userRepository.findById(id).isPresent()) {
      this.userRepository.deleteById(id);
      return true;
    }
    return false;
  }

  // save(): create or replace
  @Override
  public UserEntity updateUser(Long id, UserEntity entity) {
    if (id == null || entity == null || !id.equals(entity.getId())) {
      throw new IllegalArgumentException();
    }
    if (this.userRepository.findById(id).isPresent()) {
      return this.userRepository.save(entity);
    }
    return null; // throw new NotFoundException()
  }

  @Override
  public UserEntity patchUserWebsite(Long id, String website) {
    if (id == null || website == null) {
      throw new IllegalArgumentException();
    }
    Optional<UserEntity> userEntity = this.userRepository.findById(id);
    if (userEntity.isPresent()) {
      UserEntity entity = userEntity.get();
      entity.setWebsite(website);
      return this.userRepository.save(entity);
    }
    return null; // throw new NotFoundException()
  }

  @Override
  public UserEntity createUser(UserEntity userEntity) {
    return this.userRepository.save(userEntity);
  }
}