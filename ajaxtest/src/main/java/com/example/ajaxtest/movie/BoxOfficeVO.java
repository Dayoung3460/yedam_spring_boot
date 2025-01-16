package com.example.ajaxtest.movie;

import lombok.Data;

import java.util.List;

@Data
public class BoxOfficeVO {
  private String boxOfficeType;
  private String showRange;
  private List<DailyBoxOfficeVO> dailyBoxOfficeVOList;
}
