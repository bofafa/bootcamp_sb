package com.bootcamp.demo_post.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bootcamp.demo_post.entity.AddressEntity;
import com.bootcamp.demo_post.entity.CompanyEntity;
import com.bootcamp.demo_post.entity.GeoEntity;
import com.bootcamp.demo_post.entity.UserEntity;
import com.bootcamp.demo_post.service.UserService;
import com.bootcamp.demo_post.userRepository.AddressRepository;
import com.bootcamp.demo_post.userRepository.CompanyRepository;
import com.bootcamp.demo_post.userRepository.GeoRepository;
import com.bootcamp.demo_post.userRepository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
  @Autowired
  private UserRepository userRepository;

  @Autowired
  private AddressRepository addressRepository;

  @Autowired
  private GeoRepository geoRepository;

  @Autowired
  private CompanyRepository companyRepository;

  @Override
  public List<UserEntity> getAllDataFromDatabase() {
    return userRepository.findAll();
  }

  @Override
  public List<UserEntity> saveAll(List<UserEntity> userEntities) {
    return userRepository.saveAll(userEntities);
  }

  @Override
  public List<AddressEntity> saveAlladdress(List<AddressEntity> addressEntity) {
    return addressRepository.saveAll(addressEntity);
  }

  @Override
  public List<GeoEntity> saveAllGeos(List<GeoEntity> geoEntity) {
    return geoRepository.saveAll(geoEntity);
  }

  @Override
  public List<CompanyEntity> saveAllcompany(List<CompanyEntity> companyEntity) {
    return companyRepository.saveAll(companyEntity);
  }

  @Override
  public List<UserEntity> getUserByID(Integer userID) {
  return   userRepository.findAll().stream()//
        .filter(user -> userID.equals(user.getId()))//
        .collect(Collectors.toList());

        
  }

}
