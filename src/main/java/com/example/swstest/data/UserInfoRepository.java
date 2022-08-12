/*
 */
package com.example.swstest.data;

import com.example.swstest.entity.UserInfo;
import org.springframework.data.r2dbc.repository.R2dbcRepository;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Sovereign
 */
@Repository
public interface UserInfoRepository
extends ReactiveCrudRepository<UserInfo, Long>, R2dbcRepository<UserInfo, Long> {
  
}
