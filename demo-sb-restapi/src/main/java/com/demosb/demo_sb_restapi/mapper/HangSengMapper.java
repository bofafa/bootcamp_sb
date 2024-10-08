package com.demosb.demo_sb_restapi.mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.demosb.demo_sb_restapi.dto.HangSengCatDTO;
import com.demosb.demo_sb_restapi.dto.HangSengCatDTO.EyeDTO;
import com.demosb.demo_sb_restapi.model.Cat;

public class HangSengMapper {

  public static List<HangSengCatDTO> map(List<Cat> cats) {
    // return cats.stream() //
    // .map(cat -> {
    // HangSengCatDTO.EyeDTO[] eyes = new HangSengCatDTO.EyeDTO[] {
    // new HangSengCatDTO.EyeDTO(cat.getLeftEye().getColor()),
    // new HangSengCatDTO.EyeDTO(cat.getRightEye().getColor()) };
    // return HangSengCatDTO.builder() //
    // .name(cat.getName()) //
    // .age(cat.getAge()) //
    // .eyes(eyes) //
    // .tail(new HangSengCatDTO.TailDTO(cat.getTailLength())) //
    // .build();
    // })//
    // .collect(Collectors.toList());
    return cats.stream()//
        .map(cat -> {
          HangSengCatDTO.EyeDTO[] eyes = new EyeDTO[] { //
              new EyeDTO(cat.getLeftEye().getColor()), //
              new EyeDTO(cat.getRightEye().getColor()) };
          return HangSengCatDTO.builder()//
              .name(cat.getName())//
              .age(cat.getAge())//
              .eyes(eyes)//
              .tail(new HangSengCatDTO.TailDTO(cat.getTailLength()))//
              .build();
        })//
        .collect(Collectors.toList());
  }
}