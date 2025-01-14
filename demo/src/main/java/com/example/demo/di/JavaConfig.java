package com.example.demo.di;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

//@Configuration
public class JavaConfig {
  
  @Bean // return된 클래스를 빈으로 등록
  public Speaker speaker() {
    System.out.println("speaker 등록");
    return new SonySpeaker();
  }
  
  @Bean
  public TV tv() {
    System.out.println("tv 등록");
    return new LgTV(speaker());
  }
}
