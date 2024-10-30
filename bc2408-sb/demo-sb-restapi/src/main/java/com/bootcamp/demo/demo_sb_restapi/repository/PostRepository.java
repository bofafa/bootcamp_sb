package com.bootcamp.demo.demo_sb_restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import com.bootcamp.demo.demo_sb_restapi.entity.PostEntity;

@Repository
public interface PostRepository extends JpaRepository<PostEntity, Long> {
  // JPQL
  // select from Entity
  // where attribute
  @Query("SELECT p FROM PostEntity p WHERE p.title = :title")
  PostEntity findPostEntity(@Param("title") String title);
}
