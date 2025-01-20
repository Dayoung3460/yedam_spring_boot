package com.example.security;

import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.juli.logging.LogFactory;
import org.slf4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.web.ErrorResponse;

import java.io.IOException;

public class CustomAccessDeniedHandler implements AccessDeniedHandler {
//  private Logger log = LoggerFactory.getLog(CustomAccessDeniedHandler.class);
//  private final ObjectMapper objectMapper;
  
  @Override
  public void handle(HttpServletRequest request,
                     HttpServletResponse response,
                     AccessDeniedException accessDeniedException) throws IOException, ServletException {
    System.out.println("No Authorities: " + accessDeniedException);
    System.out.println("Request Uri : " + request.getRequestURI());
    
//    ApiResponse<ErrorResponse> apiResponse = ApiResponse.createAuthoritiesError();
//    String responseBody = objectMapper.writeValueAsString(apiResponse);
    
    response.setContentType(MediaType.APPLICATION_JSON_VALUE);
    response.setStatus(HttpStatus.FORBIDDEN.value());
    response.setCharacterEncoding("UTF-8");
    response.getWriter().write("permission error");
  }
}