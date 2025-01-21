package com.example.demo.Controller;

import com.example.demo.service.BookDTO;
import com.example.demo.service.BookService;
import com.example.demo.service.RentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@Controller
public class BookController {
  private final BookService bookService;
  private final RentService rentService;
  
  @Autowired
  public BookController(BookService bookService, RentService rentService) {
    this.bookService = bookService;
    this.rentService = rentService;
  }
  
  @GetMapping("/")
  public String index() {
    return "index";
  }
  
  @GetMapping("/register")
  public void register(BookDTO bookDTO) {
  
  }
  
  @PostMapping("/register")
  public void registerPost(BookDTO bookDTO, Model model) {
    boolean bool = bookService.register(bookDTO);
    System.out.println("bool = " + bool);
//    model.addAttribute("isRegistered", bool);
//    return "register";
  }
  
  @GetMapping("/list")
  public void list(Model model) {
    model.addAttribute("list", bookService.getList());
  }
  @GetMapping("/rent")
  public void rentList(Model model) {
    model.addAttribute("list", rentService.getRentList());
  }
}
