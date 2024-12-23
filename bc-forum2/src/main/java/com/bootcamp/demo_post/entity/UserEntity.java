package com.bootcamp.demo_post.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@Entity
@Table(name = "users")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
@ToString
public class UserEntity implements Serializable {
  @Id // Primary Key
  @GeneratedValue(strategy = GenerationType.IDENTITY) // IDENTIT, MSSQL auto−increment
  @Column(name = "user_id")
  private Integer id;
  private String name;
  private String username;
  private String phone;
  private String website;
  private String email;
 

  // All -> Remove + Persist + Merge, do not use CascadeType all, if delect one 
  @OneToOne(mappedBy = "user",
   cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private AddressEntity address;

  @OneToOne(mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private CompanyEntity company;

  @Builder.Default
  @OneToMany (mappedBy = "user", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private List<PostEntity> posts = new ArrayList<>();
}
