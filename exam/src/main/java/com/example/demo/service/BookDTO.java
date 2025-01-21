package com.example.demo.service;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class BookDTO {
  private Long bookNo;
  private String bookName;
  private String bookCoverimg;
  private Date bookDate;
  private Long bookPrice;
  private String bookPublisher;
  private String bookInfo;
}
