package com.bootcamp.demo_post.userRepository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bootcamp.demo_post.entity.GeoEntity;

public interface GeoRepository extends JpaRepository <GeoEntity, Integer> {
  
}
