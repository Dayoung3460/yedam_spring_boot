package com.example.common.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Component
@Aspect
@Slf4j
public class LogAdvice {
  // Impl로 끝나는 class안의 모든 메소드
  @Pointcut("execution(* com.example..*Impl.*(..))")
  public void allpointcut() {}
  
  // Impl class안에서 get으로 시작하는 메소드
  @Pointcut("execution(* com.example..*Impl.get*(..))")
  public void getpointcut() {}
  
  @Before("allpointcut()")
  public void log(JoinPoint jp) {
    String methodname = jp.getSignature().getName();
    log.info("Before methodname: {}", methodname);
    
    Object[] obj = jp.getArgs();
    if(obj != null) {
      log.info("parameter={}");
      Arrays.asList(obj).forEach(p -> log.info(p.toString()));
    }
  }
  
  @AfterReturning(value = "getpointcut()", returning = "result")
  public void after(JoinPoint jp, Object result) {
    String methodname = jp.getSignature().getName();
    log.info("AfterReturning methodname: {}", methodname);
    log.info("result: {}", result);
  }
}
