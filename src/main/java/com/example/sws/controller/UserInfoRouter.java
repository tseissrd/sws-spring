/*
 */
package com.example.sws.controller;

import com.example.sws.entity.UserInfo;
import com.example.sws.service.UserInfoService;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
  public Mono<ResponseEntity> getUserInfo(@PathVariable("id") Long id) {
    return service.read(id)
      .map(info -> (ResponseEntity)ResponseEntity.ok()
        .body(info)
      )
      .switchIfEmpty(
        Mono.just(
          ResponseEntity.status(
            HttpStatus.NOT_FOUND
          ).body("Could not find info for ID " + id)
        )
      );
  }
  
  @PostMapping
  public Mono<UserInfo> saveUserInfo(@RequestBody @Valid UserInfo info) {
    return service.create(info);
  }
  
}
