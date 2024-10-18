package com.bootcamp.demo_post.userRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bootcamp.demo_post.entity.CompanyEntity;

@Repository
public interface CompanyRepository  extends JpaRepository<CompanyEntity, Integer>{

  
}
