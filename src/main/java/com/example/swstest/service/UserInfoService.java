/*
 */
package com.example.swstest.service;

import com.example.swstest.data.UserInfoRepository;
import com.example.swstest.entity.UserInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

/**
 *
 * @author Sovereign
 */
@Component
public final class UserInfoService {
  
  @Autowired
  private UserInfoRepository repository;
  
  public Mono<UserInfo> read(Long id) {
    return repository.findById(id);
  }
  
  public Mono<UserInfo> create(UserInfo info) {
    return repository.save(info);
  }
  
  private UserInfoService() {}
  
}
