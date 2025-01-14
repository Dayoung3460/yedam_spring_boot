package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class DemoApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
}

/*
DI: 3가지가 있음.
1. 필드 주입: @Autowired 사용
2. *생성자 주입: final @Data or @RequireArgConstructor
3. 세터 주입: @Setter()

@Component: 객체 생성해서 컨테이너 빈으로 등록, 싱글톤 디자인패턴
	@Controller: 빈등록(@Component 기능 기본적으로 가지고 있음) + 서블릿 커맨드
		- servlet command: Spring MVC에서 요청을 처리하기 위해 사용되는 컨트롤러 메서드와 이를 매핑하는 매커니즘
		- @Controller가 추가된 클래스가 빈으로 등록되고 HTTP 요청 처리를 위해 DispatcherServlet과 연결됨
		- DispatcherServlet: 모든 http 요청을 중앙에서 처리하고 적절한 컨트롤러에 전달함
			- DispatcherServlet은 @RequestMapping or @GetMapping 등의 정보를 기반으로 요청 url을 해당 컨트롤러 메서드와 매핑
				이 매핑 정보가 서블릿 커맨드
			- ex) @GetMapping("/hello") : /hello 요청 처리하는 메서드와 매핑 => HandlerMethod라는 객체가 관리함
	@Service: 빈등록 + 트랜젝션, 에러처리
	@Repository: 빈등록
	
---------------------------


	
	
	
	

 */
