package com.bootcamp.demo_post.service;

import java.util.List;

import com.bootcamp.demo_post.entity.UserPostCommentEntity;
import com.bootcamp.demo_post.model.Comment;
import com.bootcamp.demo_post.model.Post;
import com.bootcamp.demo_post.model.UserDTO;
import com.bootcamp.demo_post.model.UserPostCommentDTO;

public interface JPHCommentService {


List<UserDTO> getUser();
List<Post> getPost();
List<Comment> getComment();
//List<CommentDTO> getUserPostComment();

}