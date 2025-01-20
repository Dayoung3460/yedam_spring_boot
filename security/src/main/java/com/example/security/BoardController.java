package com.example.security;

import com.example.security.service.CustomerUser;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Slf4j
@Controller
public class BoardController {
  // 요청 들어올 때마다 주입됨
  @Autowired
  HttpSession session;
  
  @GetMapping("/home")
  public void home() {
    CustomerUser userDetails = getCustomerUser();
    log.info("userDetails: {}", userDetails.getUserDTO().getDeptName());
    log.info("session: {}", session.getAttribute("deptName"));
    
  }
  
  private static CustomerUser getCustomerUser() {
    CustomerUser userDetails =
      (CustomerUser) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    return userDetails;
  }
}
