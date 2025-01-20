package com.example.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/*
안에 @Component 들어있음
싱글톤 보장
 */
@Configuration
public class MvcConfig implements WebMvcConfigurer {
  
  public void addViewControllers(ViewControllerRegistry registry) {
    registry.addViewController("/home").setViewName("home");
    registry.addViewController("/").setViewName("home");
    registry.addViewController("/hello").setViewName("hello"); // login 안하고 바로 /hello로 접근하면 403에러남
    registry.addViewController("/login").setViewName("login");
    registry.addViewController("/admin").setViewName("admin");
  }
  
}