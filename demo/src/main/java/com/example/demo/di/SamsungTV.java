package com.example.demo.di;

import lombok.Data;
import org.springframework.stereotype.Component;

@Data
public class SamsungTV implements TV {
  
  final Speaker speaker;
  
  @Override
  public void powerOn() {
    System.out.println("삼성 TV--전원 on");
  }
  @Override
  public void powerOff() {
    System.out.println("삼성 TV--전원 off");
  }
  @Override
  public void volumeUp() {
    System.out.println("삼성 TV--볼륨 up");
  }
  @Override
  public void volumeDown() {
    System.out.println("삼성 TV--볼륨 down");
  }
  
  @Override
  public void soundUp() {
  
  }
  
  @Override
  public void soundDown() {
  
  }
}