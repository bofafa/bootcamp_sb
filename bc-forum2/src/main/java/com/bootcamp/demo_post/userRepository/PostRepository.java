package com.bootcamp.demo_post.userRepository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.bootcamp.demo_post.entity.PostEntity;
@Repository
public interface PostRepository extends JpaRepository<PostEntity, Integer> {
@Query (value = "SELECT p FROM PostEntity p WHERE p.title =:title")
List<PostEntity> findPostEntity(@Param ("title") String title);




}