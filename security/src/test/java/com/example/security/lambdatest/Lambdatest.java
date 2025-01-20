package com.example.security.lambdatest;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

@SpringBootTest
public class Lambdatest {
  
  @Test
  void sort() {
    List<SampleVO> list = Arrays.asList(
      new SampleVO("hong", 10),
      new SampleVO("gil", 20),
      new SampleVO("dong", 30));
//    Collections.sort(list, new SampleCompare());
    
    // 익명클래스
//    Collections.sort(list, new Comparator<SampleVO>(){
//      @Override
//      public int compare(SampleVO o1, SampleVO o2) {
//        return o1.getName().compareTo(o2.getName());
//      }
//    });
    
    // lambda
    Collections.sort(list, (SampleVO o1, SampleVO o2) -> {
      return o1.getName().compareTo(o2.getName());
    });
    
    System.out.println("list = " + list);
  }
}

