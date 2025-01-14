package com.example.demo;

import com.example.demo.di.SampleDTO;
import org.junit.jupiter.api.Test;

import java.awt.image.SampleModel;

public class LombokTest {
  @Test
  public void test() {
    // SampleDTO class에 @Builder 설정해놨기 때문에 생성자 알아서 만들어줌
    SampleDTO dto = SampleDTO.builder().name("dayoung").build();
  }
}
