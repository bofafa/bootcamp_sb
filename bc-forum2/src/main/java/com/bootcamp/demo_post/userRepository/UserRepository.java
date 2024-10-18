package com.bootcamp.demo_post.userRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bootcamp.demo_post.entity.UserEntity;

@Repository
public interface UserRepository extends JpaRepository <UserEntity, Integer> {

 }
