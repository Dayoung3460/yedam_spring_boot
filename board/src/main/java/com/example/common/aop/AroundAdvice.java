package com.example.common.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class AroundAdvice {
  // LogAdvice.allpointcut()가 실행될 때 해당 메소드 실행
  // ex) 트랜젝션 처리할 때
  @Around("LogAdvice.allpointcut()")
  public Object logTime(ProceedingJoinPoint proceedingJoinPoint) {
    // service method 실행 전
    Object obj = null;
    long start = System.currentTimeMillis();
    
    // service method calling
    try {
      obj = proceedingJoinPoint.proceed();
    } catch (Throwable e) {
      throw new RuntimeException(e);
    }
    
    
    // after calling service method
    long end = System.currentTimeMillis();
    log.info("time:{}", end - start);
    return obj;
    
  }
}
