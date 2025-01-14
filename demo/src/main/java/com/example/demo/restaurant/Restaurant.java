package com.example.demo.restaurant;

import lombok.Builder;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Data
@Builder
@Component
public class Restaurant {
  // 직접 필드주입
//  @Autowired
//  private Chef chef;
  
  // 기본생성자 주입
  private final Chef chef; // lombok이 기본생성자 생성하면서 필드주입
  
  public Restaurant(Chef chef) {
    this.chef = chef;
  }
}
