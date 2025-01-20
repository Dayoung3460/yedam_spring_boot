package com.example.security;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootApplication
@MapperScan(basePackages = "com.example.**.mapper")
public class SecurityApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecurityApplication.class, args);
	}

}

/*
client -> *filter* -> frontController/servlet -> *interceptor* -> controller -> *aop advice* -> service

filter: servlet 앞단에서. 권한체크
interceptor: controller앞단에서 권한체크(or locale check)를 함
listener: session의 상태가 변경될 때 감지하고 처리함
	특정 이벤트가 발생했을 때 실행되는 이벤트 기반 프로그래밍
*/