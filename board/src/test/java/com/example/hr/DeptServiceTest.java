package com.example.hr;

import com.example.hr.service.DeptDTO;
import com.example.hr.service.DeptSearchDTO;
import com.example.hr.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@Slf4j
@SpringBootTest
public class DeptServiceTest {
  @Autowired
  DeptService deptService;
  
  @Test
  @DisplayName("dept list")
  public void getList() {
    DeptSearchDTO search = new DeptSearchDTO();
    
    List<DeptDTO> list = deptService.getList(search);
    log.debug(list.toString());
    
  }
}
