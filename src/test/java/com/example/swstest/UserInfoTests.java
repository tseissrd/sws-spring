/*
 */
package com.example.swstest;

import com.example.swstest.entity.UserInfo;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.web.client.RestTemplate;

/**
 *
 * @author Sovereign
 */
@SpringBootTest
public class UserInfoTests {
  
  @Test
	void postUserInfo() {
    UserInfo newUser = UserInfo.builder()
      .firstName("fn")
      .lastName("ln")
      .email("test@live.ru")
      .build();
    
    RestTemplate request = new RestTemplate();
    request.postForObject(, request, responseType)
	}
  
}
