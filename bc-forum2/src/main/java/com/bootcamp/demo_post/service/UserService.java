package com.bootcamp.demo_post.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bootcamp.demo_post.entity.AddressEntity;
import com.bootcamp.demo_post.entity.CompanyEntity;
import com.bootcamp.demo_post.entity.GeoEntity;
import com.bootcamp.demo_post.entity.UserEntity;

@Service
public interface UserService {

    List<UserEntity> getAllDataFromDatabase();

    List<UserEntity> saveAll(List<UserEntity> userEntities);

    List<AddressEntity> saveAlladdress(List<AddressEntity> addressEntity);

   List<GeoEntity> saveAllGeos(List<GeoEntity> geoEntities);
  
   List<CompanyEntity> saveAllcompany(List<CompanyEntity> companyEntities);
  
   List<UserEntity> getUserByID(Integer userID);
}
