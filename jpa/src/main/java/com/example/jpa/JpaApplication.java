package com.example.jpa;

import com.example.jpa.domain.Customer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import com.example.jpa.domain.CustomerRepository;

@Slf4j
@SpringBootApplication
public class JpaApplication {
	
	public static void main(String[] args) {
		SpringApplication.run(JpaApplication.class, args);
		
		
		
	}
	
//	@Bean
//	public CommandLineRunner demo (CustomerRepository repository){
//		return (args) -> {
//			//	save	a	few	customers
////			repository.save(Customer.builder().name("Jack").phone("010-3-3335").build());
////			repository.save(Customer.builder().name("Chloe").phone("010-23-3335").build());
////			repository.save(Customer.builder().name("Kim").phone("0-2333-6335").build());
////			repository.save(Customer.builder().name("David").phone("010-213335").build());
////			repository.save(Customer.builder().name("Michelle").phone("0333-3338").build());
//
//			repository.save(new	Customer("Jack",	"010"));
//			repository.save(new Customer("Chloe",	"111"));
//			repository.save(new Customer("Kim",	"222"));
//			repository.save(new Customer("Kim",	"232"));
//			repository.save(new Customer("David",	"333"));
//			repository.save(new Customer("Michelle",	"444"));
//
//			//	fetch	all	customers
//			log.info("Customers	found	with	findAll():");
//			log.info("-------------------------------");
//			for (Customer customer : repository.findAll()) {
//				log.info(customer.toString());
//			}
//			log.info("");
//		};
//	}
}
