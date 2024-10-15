package com.bootcamp.demo_jph.mapper;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.bootcamp.demo_jph.dto.user;
import com.bootcamp.demo_jph.entity.UserEntity;


@Component // use companent because not in 
           
public class JPHMapper {
  // reivse from static method to instance
  public UserEntity map(user user) {
    return UserEntity.builder() //
        .addrLat(user.getAddress().getGeo().getLat()) //
        .addrLng(user.getAddress().getGeo().getLng()) //
        .addrCity(user.getAddress().getCity()) //
        .addrStreet(user.getAddress().getStreet()) //
        .addrSuite(user.getAddress().getSuite()) //
        .addrZipcode(user.getAddress().getZipcode()) //
        .comBs(user.getCompany().getBs()) //
        .comCatchPhrase(user.getCompany().getCatchPhrase()) //
        .comName(user.getCompany().getName()) //
        .name(user.getName()) //
        .username(user.getUsername()) //
        .phone(user.getPhone()) //
        .website(user.getWebsite()) //
        .build();
  }
}