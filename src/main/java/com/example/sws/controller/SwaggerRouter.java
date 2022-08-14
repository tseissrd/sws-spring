/*
 */
package com.example.sws.controller;

import java.net.URI;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import reactor.core.publisher.Mono;
import springfox.documentation.annotations.ApiIgnore;

/**
 *
 * @author Sovereign
 */
@Controller
@ApiIgnore
public class SwaggerRouter {
  
  @RequestMapping("/")
  public Mono<ResponseEntity<String>> redirectToSwagger() {
    return Mono.just(
      URI.create("/swagger-ui/index.html")
    ).map(redirect -> ResponseEntity.status(
        HttpStatus.SEE_OTHER
      ).location(redirect)
        .build()
      );
  }
  
}
