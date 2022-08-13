/*
 */
package com.example.sws.service;

import com.example.sws.data.UserInfoRepository;
import com.example.sws.entity.UserInfo;
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
    return repository.save(
      UserInfo.builderFrom(info)
        .id(null)
        .build()
    );
  }
  
  private UserInfoService() {}
  
}
