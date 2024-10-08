package com.demosb.demo_sb_restapi.mapper;

import java.util.List;
import java.util.stream.Collectors;

import com.demosb.demo_sb_restapi.dto.GovCatDTO;
import com.demosb.demo_sb_restapi.model.Cat;

public class GovCatMapper {


    public static List<GovCatDTO> govMap(List<Cat> cats) {
      return cats.stream() //
          .map(cat -> {
            return  GovCatDTO.builder() //
            .tail(new GovCatDTO.Tail(cat.getTailLength())).build();
    }).collect(Collectors.toList());
    }
  }
