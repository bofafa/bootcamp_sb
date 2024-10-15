package com.bootcamp.bc_calculator.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@Builder
@NoArgsConstructor
@ToString
public class CalculateResponse {
  private String x;
  private String y;
  private String operation;
  private String result;
}
