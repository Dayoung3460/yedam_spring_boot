package com.example.common;

import lombok.Data;

@Data
public class Paging {
  int pageUnit=10 ;  //한페이지 출력할 레코드 건수
  int pageSize=10 ;  //페이지번호 수 (5) 1~ 5까지 page group
  int lastPage;      //마지막 페이지번호
  int totalRecord;  //전체 레코드건수
  Integer page = 1;	  //현재 페이지
  int startPage;  //페이지그룹내에서 시작페이지번호
  int endPage;  //페이지그룹내에서 마지막페이지번호
  int first;// BoardSearchDTO로 넘겨줄 페이지그룹 내의 첫번째 rownum
  int last;//BoardSearchDTO로 넘겨줄 페이지그룹 내의 마지막 rownum
  
  public int getFirst() {
    first = (getPage() - 1) * getPageUnit() + 1;
    return first;
  }
  
  public int getLast() {
    // 5 * 10 = 50
    last = getPage() * getPageUnit();
    return last;
  }
  
  public int getPageUnit() {
    return pageUnit;
  }
  
  public void setPageUnit(int pageUnit) {
    this.pageUnit = pageUnit;
  }
  
  public int getPageSize() {
    return pageSize;
  }
  
  public void setPageSize(int pageSize) {
    this.pageSize = pageSize;
  }
  
  // the very last page
  public int getLastPage() {
    lastPage = totalRecord / pageUnit +
      ( totalRecord % pageUnit>0 ? 1 : 0 );
    return lastPage;
  }
  
  public void setLastPage(int lastPage) {
    this.lastPage = lastPage;
  }
  
  public int getTotalRecord() {
    return totalRecord;
  }
  
  public void setTotalRecord(int totalRecord) {
    this.totalRecord = totalRecord;
  }
  
  public Integer getPage() {
    return page;
  }
  
  public void setPage(Integer page) {
    this.page = page;
  }
  
  // the start page of page group
  public int getStartPage() {
    // page: 32
    // pageSize: 10
    // startPage = 3 * 10 + 1 = 31
    startPage = (page-1)/pageSize * pageSize + 1;
    return startPage;
  }
  
  public void setStartPage(int startPage) {
    this.startPage = startPage;
  }
  
  // the last page of page group
  public int getEndPage() {
    // page: 5
    // pageSize: 10
    // (page-1)/pageSize = 0 (int 형이라)
    // endPage: 0 * 10 + 10 = 10
    endPage = (page-1)/pageSize * pageSize  + pageSize ;
    if ( endPage > getLastPage() )
      endPage = getLastPage() ;
    return endPage;
  }
  
  public void setEndPage(int endPage) {
    this.endPage = endPage;
  }
  
}