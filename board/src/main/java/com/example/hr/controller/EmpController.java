package com.example.hr.controller;

import com.example.hr.service.EmployeeService;
import groovy.transform.ASTTest;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Slf4j
@Controller
@RequiredArgsConstructor
@RequestMapping("/emp/*")
public class EmpController {
  private final EmployeeService employeeService;
  
  @GetMapping("list")
  public void getList(Model model) {
    model.addAttribute("list", employeeService.getList());
  }
  
}
