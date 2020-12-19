package com.malkovro.monitoring_api

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
class HelloController {

  @GetMapping("/hello")
  fun hello(@RequestParam(value = "name", defaultValue = "World") name: String): String {
    return String.format("Hello %s! Currently running on ", name);
  }  
}