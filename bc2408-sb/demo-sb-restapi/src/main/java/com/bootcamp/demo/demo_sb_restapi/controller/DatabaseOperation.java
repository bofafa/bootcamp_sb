package com.bootcamp.demo.demo_sb_restapi.controller;

import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

// ! What is Restful API?
  // URI -> resource
  // Get, Post, Delete, Put
public interface DatabaseOperation {
  @PostMapping("/integers/{index}/{value}")
  public int put(@PathVariable int index, @PathVariable int value);

  // http://localhost:8081/integers/get/2
  @GetMapping("/integers/{index}")
  public int get(@PathVariable int index);

  // http://localhost:8081/integers?idx=2
  @GetMapping("/integers")
  public int get2(@RequestParam(value = "idx") int index);

  @GetMapping("/integers/getall")
  public List<Integer> getAll();

  // @DeleteMapping -> SQL: delete from
  // @PutMapping -> SQL: update
  // @GetMapping -> SQL: Select
  // @PostMapping -> SQL: insert into
  
}