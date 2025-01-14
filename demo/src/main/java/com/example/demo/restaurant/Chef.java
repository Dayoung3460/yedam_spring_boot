package com.example.demo.restaurant;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

@Data
@Builder
@Component
@NoArgsConstructor // 기본생성자 추가됨
@AllArgsConstructor
public class Chef {
  private String name;
}
