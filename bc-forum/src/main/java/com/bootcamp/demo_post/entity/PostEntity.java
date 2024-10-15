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
@Table(name = "post")
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
public class PostEntity  implements Serializable{
 @Id
 @GeneratedValue (strategy = GenerationType.IDENTITY)
  private int userId;
  private int id;
   @Column(name = "post_topic")
  private String title;
  @Column(name = "post_body")
  private String body;

}
