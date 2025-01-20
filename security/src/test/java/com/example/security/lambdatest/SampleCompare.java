package com.example.security.lambdatest;

import org.springframework.boot.test.context.SpringBootTest;
import java.util.Comparator;

class SampleCompare implements Comparator<SampleVO> {
  
  @Override
  public int compare(SampleVO o1, SampleVO o2) {
    return o1.getName().compareTo(o2.getName());
    //    return o1.getAge() - o2.getAge();
  }
}
