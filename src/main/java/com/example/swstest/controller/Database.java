/*
 */
package com.example.swstest.controller;

import com.example.swstest.data.UserInfoRepository;
import com.example.swstest.entity.UserInfo;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

/**
 *
 * @author Sovereign
 */
@RestController
@RequestMapping("/db")
public class Database {
  
  @Autowired
  private UserInfoRepository repository;
  
  @PostMapping
  private Mono<Void> saveUserInfo(@RequestBody @Valid UserInfo info) {
    return repository.save(info)
      .then();
  }
  
}
