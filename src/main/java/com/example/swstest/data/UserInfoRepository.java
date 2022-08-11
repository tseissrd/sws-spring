/*
 */
package com.example.swstest.data;

import com.example.swstest.entity.UserInfo;
import org.springframework.data.r2dbc.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Sovereign
 */
@Repository
public interface UserInfoRepository {
  
  @Query("INSERT INTO userinfo () VALUES ()")
  public void save(UserInfo info);
  
}
