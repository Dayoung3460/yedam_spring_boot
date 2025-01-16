package com.example.ajaxtest;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class CompVO {
  private List<Ticket> list;
  private SampleVO sample;
  private int cnt;
  private Date regdate;
}
