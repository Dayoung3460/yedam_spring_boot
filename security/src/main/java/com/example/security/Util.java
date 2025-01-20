package com.example.security;

import com.example.security.service.CustomerUser;
import com.example.security.service.UserDTO;
import org.springframework.security.core.context.SecurityContextHolder;

public class Util {
  public static UserDTO getUser() {
    Object obj = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    UserDTO userDetails = null;
    System.out.println("obj = " + obj);
    
//    if(!obj instanceof ) {
      userDetails = ((CustomerUser) obj).getUserDTO();
//    } else {
//      userDetails = new UserDTO();
//    }
    
    return userDetails;
    
  }

}
