/*
 */
package com.example.swstest;

import com.example.swstest.controller.UserInfoRouter;
import com.example.swstest.entity.UserInfo;
import com.example.swstest.service.UserInfoService;
import org.junit.jupiter.api.Test;
import static org.mockito.ArgumentMatchers.*;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.reactive.WebFluxTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.test.web.reactive.server.WebTestClient;
import reactor.core.publisher.Mono;

/**
 *
 * @author Sovereign
 */
@WebFluxTest(UserInfoRouter.class)
public class UserInfoTests {
  
  static {
    String firstName = "fn";
    String lastName = "ln";
    String email = "test@yandex.ru";
    
    infoMockInput = UserInfo.builder()
      .firstName(firstName)
      .lastName(lastName)
      .email(email)
      .build();
    
    infoMockResult = UserInfo.builder()
      .firstName(firstName)
      .middleName(null)
      .lastName(lastName)
      .email(email)
      .phone(null)
      .id((long)1)
      .build();
  }
  
  private static final UserInfo infoMockInput;
  private static final UserInfo infoMockResult;
  
  @Autowired
  private WebTestClient webClient;
  
  @MockBean
  private UserInfoService service;
  
  @Test
  void getUserInfo() {
    Mockito.when(
      service.read(Long.valueOf(1))
    ).thenReturn(
      Mono.just(infoMockResult)
    );
    
    webClient.get()
      .uri("/userinfo/1")
      .header(HttpHeaders.ACCEPT, "application/json")
      .exchange()
      .expectBody(UserInfo.class)
      .isEqualTo(infoMockResult);
    
    Mockito.verify(service).read(Long.valueOf(1));
  }
  
  @Test
	void postUserInfo() {
    Mockito.when(
      service.create(
        any(UserInfo.class)
      )
    ).thenAnswer(invocation -> {
      UserInfo input = invocation.getArgument(0, UserInfo.class);
      return Mono.just(
        UserInfo.builderFrom(input)
          .id(Long.valueOf(1))
          .build()
      );
    });
    
    webClient.post()
      .uri("/userinfo")
      .header(HttpHeaders.ACCEPT, "application/json")
      .header(HttpHeaders.CONTENT_TYPE, "application/json")
      .bodyValue(infoMockInput)
      .exchange()
      .expectBody(UserInfo.class)
      .isEqualTo(infoMockResult);
    
    Mockito.verify(service).create(infoMockInput);
	}
  
}
