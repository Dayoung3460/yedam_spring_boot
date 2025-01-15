package com.example.hr.controller;


import com.example.common.Paging;
import com.example.hr.service.DeptDTO;
import com.example.hr.service.DeptSearchDTO;
import com.example.hr.service.DeptService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Slf4j
@Controller
@RequestMapping("/dept/*")
public class DeptController {
  private final DeptService service;
  
  @Autowired
  public DeptController(DeptService service){
    this.service = service;
  }
  
  @GetMapping("list")
  public void list(Model model, DeptSearchDTO searchDTO, Paging paging) {
    log.info("dept list");
    
    paging.setTotalRecord(service.count(searchDTO));
    
    searchDTO.setStart(paging.getFirst());
    searchDTO.setEnd(paging.getLast());
    model.addAttribute("list", service.getList(searchDTO));
  }
  
  @GetMapping("get")
  public DeptDTO get(@RequestParam(name="departmentId") long departmentId) {
    return service.read(departmentId);
  }
}
