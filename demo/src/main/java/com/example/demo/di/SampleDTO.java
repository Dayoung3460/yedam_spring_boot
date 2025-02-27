package com.example.demo.di;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder // 생성자 만들어줌
@NoArgsConstructor
@AllArgsConstructor
public class SampleDTO {
  private String name;
  private int age;
  private String tel;
}
