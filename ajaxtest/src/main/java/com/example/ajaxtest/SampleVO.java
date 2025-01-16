package com.example.ajaxtest;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class SampleVO {
  // json string으로 변환안됨. 무시됨
  @JsonIgnore
  private int mno;
  // json string으로 변환될 때 키값 설정
//  @JsonProperty("fname")
  private String firstName;
  private String lastName;
  @JsonFormat(pattern = "yyyy-MM-dd")
  private Date regDate;
}
