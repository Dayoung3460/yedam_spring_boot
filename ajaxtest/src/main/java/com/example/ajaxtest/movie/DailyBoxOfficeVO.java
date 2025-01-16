package com.example.ajaxtest.movie;

import lombok.Data;

import java.util.Date;

@Data
public class DailyBoxOfficeVO {
  private int rnum;
  private int rank; //": "1",
  private int rankInten; //": "0",
  private String rankOldAndNew; //": "OLD",
  private int movieCd; //": "20228796",
  private String movieNm; //": "하얼빈",
  private Date openDt; //": "2024-12-24",
  private int salesAmt; //": "294505980",
  private double salesShare; //": "28.2",
  private int salesInten; //": "-17513600",
  private double salesChange; //": "-5.6",
  private long salesAcc; //": "40945649090",
  private int audiCnt; //": "31915",
  private int audiInten; //": "-710",
  private double audiChange; //": "-2.2",
  private int audiAcc; //": "4282201",
  private int scrnCnt; //": "1073",
  private int showCnt; //": "3891"
}
