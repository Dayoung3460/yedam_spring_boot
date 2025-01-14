package com.example.demo;

import com.example.demo.di.SamsungTV;
import com.example.demo.di.TV;
import com.example.demo.restaurant.Chef;
import com.example.demo.restaurant.Restaurant;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class DITest {
//  @Autowired TV tv; // TV interface wired
  @Autowired ApplicationContext context; // String IoC Container with beans
  
  @Test
  @DisplayName("create object")
  public void test1() {
    
    TV tv = context.getBean(TV.class);
    tv.powerOn();
    tv.volumeUp();
    tv.volumeDown();
//    tv.soundUp();
//    tv.soundDown();
    tv.powerOff();
  }
  
  @Autowired
  Restaurant restaurant;
  
  @Test
  @DisplayName("ditest02")
  public void ditest02() {
    String chefName = "kim";
    Restaurant restaurant1 = new Restaurant(new Chef(chefName));
    System.out.println("restaurant1 = " + restaurant1);
    System.out.println("restaurant.getChef() = " + restaurant.getChef());
    
    assertNotNull(restaurant.getChef());
  }
}