package com.demosb.demo_sb_restapi.controller;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demosb.demo_sb_restapi.model.Cat;

import lombok.Getter;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@Controller
@ResponseBody
@Getter
public class CatController {
 //1.return cat objcect ("john")
// 2. return list of cat ("peter, vincent")
//3. return  a cat (path variable at name)

  @GetMapping(value = "/cat/name")
   public Cat getCat() {
   return new Cat("John");
}


     @GetMapping(value = "/cat/catlist")
     public List<Cat> getCatList() {
     return Arrays.asList(new Cat("Peter"), new Cat("Vincent"));
    }

   
    @GetMapping(value =  "/cat/{x}/")
    public String getCatName(@PathVariable String x) {
        return x;
    }
    


}

