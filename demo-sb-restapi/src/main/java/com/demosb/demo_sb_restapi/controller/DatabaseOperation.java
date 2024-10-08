package com.demosb.demo_sb_restapi.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

public interface DatabaseOperation {
  @GetMapping("/integers/intput/{index}/{value}")
  public int put(@PathVariable int index, @PathVariable int value);

  @GetMapping("/integers/get/{index}")
  public int get(@PathVariable int index);

    @GetMapping("/integers/getall")
  public List<Integer> getAll();

  @GetMapping ("/integers")
  public int get2(@RequestParam  (value = "idx") int idex);

  @GetMapping ("/integers/getall")
  public List <Integer>getall();
}
