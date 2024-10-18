package com.bootcamp.demo_post.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Entity
@Table (name = "geo")
public class GeoEntity {
@Id
@GeneratedValue  (strategy = GenerationType.IDENTITY)
    private Integer id;
    private String lat;
    private String lng;
  }


