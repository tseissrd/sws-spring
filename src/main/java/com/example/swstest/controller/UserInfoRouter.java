/*
 */
package com.example.swstest.controller;

import com.example.swstest.entity.UserInfo;
import com.example.swstest.service.UserInfoService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

/**
 *
 * @author Sovereign
 */
@RestController
@RequestMapping("/userinfo")
public class UserInfoRouter {
  
  @Autowired
  private UserInfoService service;
  
  @GetMapping("/{id}")
  private Mono<UserInfo> getUserInfo(@PathVariable("id") Long id) {
    return service.read(id);
  }
  
  @PostMapping
  private Mono<UserInfo> saveUserInfo(@RequestBody @Valid UserInfo info) {
    return service.create(info);
  }
  
}
