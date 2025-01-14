package com.example.demo;


import com.example.demo.di.SampleDTO;
import lombok.extern.log4j.Log4j;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Slf4j
@Controller// 빈등록, 서블릿 커맨드
@RequestMapping("/sample")
public class SampleController {
	
	@GetMapping("/ex05")
	public ModelAndView ex05(@ModelAttribute(name = "todo") TodoDTO dto) {
		ModelAndView mv = new ModelAndView("sample");
		mv.addObject("serverTime", new Date());
		log.debug("todoDTO={}", dto);
		return mv; // 포워드: request 전달
	}
	
	// dept 키값으로 리턴값을 넘겨줌
	// 아무 뷰라도 dept가 넘어오면 접속한 뷰에서 접근가능
	@ModelAttribute("dept")
	public List<String> deptList() {
		return Arrays.asList("기획", "개발", "인사");
	}
	
	@GetMapping("/ex01")
	public String ex01(SampleDTO dto) {
		// SampleDTO: 커맨드 객체
		
//		Spring의 데이터 바인딩 기능으로 
		//		SampleDTO의 필드와 쿼리 파라미터의 키 값이 매칭됨
		//  Spring의 Web DataBinder를 통해 이루어지며, 요청 파라미터를 Java 객체의 필드에 자동으로 매핑
		
		// * 매칭 동작 원리
		// 1. 요청 URL에 포함된 쿼리 파라미터가 HTTP 요청으로 전달됩니다.
		// 2. Spring의 HandlerMethodArgumentResolver 동작
		// 		파라미터 타입이 자바 객체면, 해당 객체 생성, 요청 파라미터를 필드에 바인딩
		// 3. 필드 타입에 따라 문자열 값을 적절한 데이터 타입으로 변환(예: age=10 → Integer 10).

//		http://localhost:82/sample/ex01?name=kim&age=10
		log.debug("dto={}", dto); // dto=SampleDTO(name=kim, age=10, tel=null)
		return "sample";
	}
	
	@GetMapping("/ex02")
	// @RequestParam 생략가능. 만약 적으면 해당 파라미터 값은 요청에서 꼭 넘어와야함
	// @RequestParam(name="username"): 요청 파라미터의 키값이 username로 넘어오면 name으로 알아들음
	// @RequestParam(defaultValue = "5"): 요청 파라미터가 안넘어오면 디폴트값 사용함
	public String ex02(@RequestParam(name="username") String name,
										 @RequestParam(required = false, defaultValue = "5") int age) {
//		http://localhost:82/sample/ex02?username=kim
		log.info("name={} age={}", name, age); //name=kim age=5
		return "sample";
	}
	
	@GetMapping("/ex02List")
	// 원시타입이면 @RequestParam 생량가능한데, 아니면 생략불가
	public String ex02List(@RequestParam List<String> hobby) {
//		http://localhost:82/sample/ex02List?hobby=kim&hobby=hobby!
		log.debug("hobby={}", hobby); // hobby=[kim, hobby!]
		return "sample";
	}
	
	@GetMapping("/ex02Bean")
	public String ex02Bean(SampleDtoList dtoList) {
//		http://localhost:82/sample/ex02Bean?list[0].name=kim&list[0].age=10&list[1].name=lee&list[1].age=20
		// [, ]:  HTTP URL에서 예약된 문자, 인코딩 처리해야함
//		http://localhost:82/sample/ex02Bean?list%5B0%5D.name=kim&list%5B0%5D.age=10&list%5B1%5D.name=lee&list%5B1%5D.age=20
		
		log.debug("dtoList: {}", dtoList); // dtoList: SampleDtoList(list=[SampleDTO(name=kim, age=10, tel=null), SampleDTO(name=lee, age=20, tel=null)])
		return "sample";
	}
	
	@GetMapping("/ex03")
	public String ex03(TodoDTO todoDTO) {
//		http://localhost:82/sample/ex03?title=coding&dueDate=2025/01/01
//		// todoDTO: TodoDTO(title=coding, dueDate=Wed Jan 01 00:00:00 KST 2025)

//		http://localhost:82/sample/ex03?title=coding&dueDate=2025/01/01%2016:12:34
//		todoDTO: TodoDTO(title=coding, dueDate=Wed Jan 01 16:12:34 KST 2025)
		
		// todoDTO에서 Date 타입 필드에 @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm") 설정해주면
//		http://localhost:82/sample/ex03?title=coding&dueDate=2025-01-01%2016:12
		//todoDTO: TodoDTO(title=coding, dueDate=Wed Jan 01 16:12:00 KST 2025)
		log.debug("todoDTO: {}", todoDTO);
		return "sample";
	}
	
	@GetMapping("/ex04")
	// Model: 뷰(View)로 데이터를 전달하는 데 사용됨
	//
	public String ex04(@ModelAttribute(name = "todoo") TodoDTO dto, Model model) {
		// sample.index 뷰에 serverTime 변수 이름으로 데이터 보내줌
		// 커맨드객체(TodoDTO)는 model.addAttribute 하지않아도 알아서 todoDTO 변수로 보내짐
		// @ModelAttribute(name = "todoo") TodoDTO dto 이렇게 직접 설정해주면 todoo 변수명으로 보내짐
		model.addAttribute("serverTime", new Date());
		log.debug("dto={}", dto);
		return "sample";
	}

//	"/sample/basica"
//	@GetMapping("basica") // GetMapping은 파라미터 하나만 보낼 때 사용
	@RequestMapping(value = "/basica", method = {RequestMethod.GET})
	public String basica() {
//		System.out.println("basica");
//		Logger log = LoggerFactory.getLogger(SampleController.class);
		log.info("log: basica");
		
		// ViewResolver에 의해 sample.html이 뷰로 뿌려짐
		return "sample";
	}
	
	@RequestMapping(value = "/basicb", method = {RequestMethod.GET})
	public String basicb() {
		log.info("log: basicb");
		return "sample";
	}
}
