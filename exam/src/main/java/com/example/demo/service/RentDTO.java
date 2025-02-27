package com.example.demo.service;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RentDTO {
  private Long bookNo;
  private String bookName;
  private Long rentAll;
  private Long rentCount;
}
