package com.demosb.demo_sb_restapi.controller.impl;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demosb.demo_sb_restapi.dto.GovCatDTO;
import com.demosb.demo_sb_restapi.mapper.GovCatMapper;
import com.demosb.demo_sb_restapi.model.Cat;
import com.demosb.demo_sb_restapi.model.Color;

// Consideration: URL design (based on api consumer and resources)
// return List<GovCatDTO>

@Controller
@ResponseBody
public class GovController {

  @GetMapping(value = "/govcats")
public List<GovCatDTO> getCats() {
  List<Cat> cats = List.of(new Cat("Vincent", 13, Color.RED, 13.0),
      new Cat("Peter", 10, Color.BLUE, 8.5),
      new Cat("Sally", 9, Color.BLUE, 12));
  return GovCatMapper.govMap(cats);
}
}