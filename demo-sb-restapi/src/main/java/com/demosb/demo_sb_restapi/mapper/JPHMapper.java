package com.demosb.demo_sb_restapi.mapper;

import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import com.demosb.demo_sb_restapi.dto.UserDTO;
import com.demosb.demo_sb_restapi.entity.UserEntity;

@Component // use companent because not in 
           
public class JPHMapper {
  // reivse from static method to instance
  public UserEntity map(UserDTO userDTO) {
    return UserEntity.builder() //
        .addrLat(userDTO.getAddress().getGeo().getLat()) //
        .addrLng(userDTO.getAddress().getGeo().getLng()) //
        .addrCity(userDTO.getAddress().getCity()) //
        .addrStreet(userDTO.getAddress().getStreet()) //
        .addrSuite(userDTO.getAddress().getSuite()) //
        .addrZipcode(userDTO.getAddress().getZipcode()) //
        .comBs(userDTO.getCompany().getBs()) //
        .comCatchPhrase(userDTO.getCompany().getCatchPhrase()) //
        .comName(userDTO.getCompany().getName()) //
        .name(userDTO.getName()) //
        .username(userDTO.getUsername()) //
        .phone(userDTO.getPhone()) //
        .website(userDTO.getWebsite()) //
        .build();
  }
}