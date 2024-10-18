package com.bootcamp.demo_post.entity;

import java.io.Serializable;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table (name ="address")
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Setter
@ToString
public class AddressEntity implements Serializable {
  @Id
  @GeneratedValue (strategy = GenerationType.IDENTITY)
  @Column(name = "address_id")
  private Integer id;
  @Column(name = "address_street")
  private String addrStreet;
  @Column(name = "address_suite")
  private String addrSuite;
  @Column(name = "address_city")
  private String addrCity;
  @Column(name = "address_zip_code")
  private String addrZipcode;


   
  @OneToOne
  @JoinColumn(name = "user_id", nullable = false)
  private UserEntity user; // getId() -> table}


  @OneToOne(mappedBy = "address", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
  private GeoEntity geo;

}