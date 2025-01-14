package com.example.demo.di;

import lombok.Data;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Data
//@RequiredArgsConstructor // 매개변수있는 생성자를 만들어줌(매개변수는 speaker, price두개)
//@Component
public class LgTV implements TV{
//  @Autowired // Speaker DI. field DI
//  @Setter(onMethod_ = {@Autowired})
  final Speaker speaker; // final 변수는 생성할 때 초기화 해야하기 때문에(LgTV 생성자에서 초기화해줘야함) 자동으로 생성자 인젝션 해줌
  int price;
//  @Autowired // constructor injection *recommended. @Autowired 생략가능
//  public LgTV(Speaker speaker) {
//    System.out.println("constructor injection");
//    this.speaker = speaker;
//  }
  
//  @Autowired // setter DI
//  public void setSpeaker(Speaker speaker) {
//    System.out.println("setter injection");
//    this.speaker = speaker;
//  }
  
  public void powerOn() {
    System.out.println("LG TV--전원 on");
  }
  public void powerOff() {
    System.out.println("LG TV--전원 off");
  }
  
  @Override
  public void volumeUp() {
    speaker.volumeUp();
  }
  
  @Override
  public void volumeDown() {
    speaker.volumeDown();
  }
  
  public void soundUp() {
    System.out.println("LG TV--볼륨 up");
  }
  public void soundDown() {
    System.out.println("LG TV--볼륨 down");
  }
}