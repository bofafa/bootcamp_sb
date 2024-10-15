package com.bootcamp.demo_post.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;


@Entity
@Table(name = "comment")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class CommentEntity  implements Serializable {
  @Id
 @GeneratedValue (strategy = GenerationType.IDENTITY)
  private int postId;
  private int id;
  private String name;
  private String email;
   @Column(name = "comment")
  private String body;
}
