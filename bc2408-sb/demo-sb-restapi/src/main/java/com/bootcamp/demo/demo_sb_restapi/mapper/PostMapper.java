package com.bootcamp.demo.demo_sb_restapi.mapper;

import org.springframework.stereotype.Component;
import com.bootcamp.demo.demo_sb_restapi.entity.PostEntity;
import com.bootcamp.demo.demo_sb_restapi.model.Post;

@Component
public class PostMapper {
  public Post map(PostEntity postEntity) {
    return Post.builder() //
        .id(postEntity.getId()) //
        .title(postEntity.getTitle()) //
        .body(postEntity.getBody()) //
        .build();
  }
}
