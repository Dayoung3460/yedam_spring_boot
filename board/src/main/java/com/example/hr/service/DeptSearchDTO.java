package com.example.hr.service;

import lombok.Data;

@Data
public class DeptSearchDTO {
  int start;
  int end;
  String type;
  String keyword;
  int pageUnit;
  
  public String[] getTypeArr() {
    return type == null ? new String[]{} : type.split("");
  }
}
