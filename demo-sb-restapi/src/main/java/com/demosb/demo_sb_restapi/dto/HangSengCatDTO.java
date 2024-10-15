package com.demosb.demo_sb_restapi.dto;


import com.demosb.demo_sb_restapi.model.Color;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

// DTO (Data Transfer Object), represents JSON format
@Getter
@AllArgsConstructor
@Builder
public class HangSengCatDTO {
  private String name;
  private int age;
  private EyeDTO[] eyes;
  private TailDTO tail;

  @Getter
  @AllArgsConstructor
  public static class EyeDTO {
    private Color color;
  }

  @Getter
  @AllArgsConstructor
  public static class TailDTO {
    private double length;
  }

}