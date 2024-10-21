package com.bootcamp.demo_post.userRepository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.bootcamp.demo_post.entity.PostEntity;


@Repository
public interface PostRepository extends JpaRepository<PostEntity, Long> {

}