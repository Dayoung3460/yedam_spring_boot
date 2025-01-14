package com.example.demo.dept;


import com.example.demo.SampleDtoList;
import com.example.demo.TodoDTO;
import com.example.demo.di.SampleDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Slf4j
@Controller
@RequestMapping("/dept")
public class deptController {
	// list, info, insert, update, update done, delete
	
	private List<DepartmentsDTO> list = new ArrayList<>();
	
	@GetMapping("/list")
	public void List(Model model) {
		log.debug("model={}", model);
//		list.add(DepartmentsDTO.builder()
//			.departmentId(10)
//			.departmentName("인사팀")
//			.managerId(20)
//			.locationId(30).build());
			
		model.addAttribute("list", list);
		
		// /dept/list로 접속해야됨
		// 근데 templates 폴더안에서 dept > list.html 이라 위와 경로가 같음
		// -> 뷰를 리턴값으로 넘겨줬었는데 그럴 필요없음
	}
	
	@GetMapping("/info")
	public void Info(Model model) {
		log.debug("model={}", model);
	}
	
	// 등록 폼을 보여주는 Insert
	@GetMapping("/insert")
	public void Insert() {
		log.debug("insert");
	}
	
	// 등록 요청을 받는 Insert
	@PostMapping("/insert")
	public String Insert(DepartmentsDTO departmentsDTO) {
		log.debug("departmentsDTO={}", departmentsDTO);
		
		list.add(departmentsDTO);
		
		// redirect: 새고안하고 리다이렉트
		return "redirect:/dept/list";
	}
}
