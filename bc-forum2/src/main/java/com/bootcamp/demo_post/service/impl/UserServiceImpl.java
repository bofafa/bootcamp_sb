package com.bootcamp.demo_post.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootcamp.demo_post.entity.AddressEntity;
import com.bootcamp.demo_post.entity.UserEntity;
import com.bootcamp.demo_post.service.UserService;
import com.bootcamp.demo_post.userRepository.AddressRepository;
import com.bootcamp.demo_post.userRepository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
  @Autowired
  private UserRepository userRepository;

  @Autowired
  private AddressRepository addressRepository;

  @Override
  public List<UserEntity> saveAll(List<UserEntity> userEntities) {
    return userRepository.saveAll(userEntities);

  }

  @Override
  public List<UserEntity> getAllDataFromDatabase() {
    return userRepository.findAll();
  };

  @Override
  public List<AddressEntity> saveAlladdress(List<AddressEntity> addressEntity) {
    return addressRepository.saveAll(addressEntity);
  }
}
