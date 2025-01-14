package com.example.demo;

import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

@Data
public class TodoDTO {
  private String title;
  @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
  private Date dueDate;
}
