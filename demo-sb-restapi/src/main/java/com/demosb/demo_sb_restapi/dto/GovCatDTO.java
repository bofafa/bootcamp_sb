package com.demosb.demo_sb_restapi.dto;

import com.demosb.demo_sb_restapi.model.Cat.Tail;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@Getter
@AllArgsConstructor
@Builder
public class GovCatDTO {
  private Tail tail;


@Getter
@AllArgsConstructor
public static class Tail {
   double length;
}

}