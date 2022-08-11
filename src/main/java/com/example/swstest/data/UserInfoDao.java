/*
 */
package com.example.swstest.data;

import com.example.swstest.entity.UserInfo;
import org.springframework.data.repository.Repository;

/**
 *
 * @author Sovereign
 */
public final class UserInfoDao {
  
  private final UserInfoRepository repository;
  
  public static final UserInfoDao getFor(Repository<UserInfo, Long> repository) {
  }
  
  private UserInfoDao(Repository<UserInfo, Long> repository) {
    this.repository.;
  }
  
  public void storeUserInfo(UserInfo info) {
    
  }
  
}
