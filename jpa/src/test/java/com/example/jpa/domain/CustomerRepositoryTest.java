package com.example.jpa.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Commit;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;

import javax.swing.text.html.Option;
import java.util.List;
import java.util.Optional;
import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
public class CustomerRepositoryTest {
  @Autowired
  CustomerRepository customerRepository;
  
  @Autowired
  AddressRepository addressRepository;
  
  @Test
  // 커밋이나 롤백 설정가능. default가 커밋.
  @Transactional
  // @Rollback: 테스트하고 롤백시켜줌
  @Commit
  public void insert() {
    // give
    // @AllArgsConstructor + @Builder: 특정 필드를 포함하지 않고 객체를 생성할 수 있
    Customer customer = Customer.builder().name("da1").phone("210-2333-3335").build();
    
    // when
    customerRepository.save(customer);
    addressRepository.save(Address.builder().address("Daegu1").customer(customer).build());
    System.out.println("customer id= " + customer.getId());
    
    // then
    Optional<Customer> result = customerRepository.findById(7L);
    Optional<Address> address = addressRepository.findById(1L);
    System.out.println("address = " + address);
    assertThat(result.get().getName()).isEqualTo("da1");
  }
  
  @Test
  public void udpate() {
    Optional<Customer> result = customerRepository.findById(1L);
    result.get().setPhone("010-3443-4441");
    // save(): 기본키가 있으면 수정, 없으면 생성됨
    customerRepository.save(result.get());
  }
  
  @Test
  public void findByName() {
    String name = "%im%";
    List<Customer> list = customerRepository.findByNameLike(name);
    System.out.println("list = " + list);
  }
  
  @Test
  public void findByNameLikeOrPhoneOrderByIdDesc() {
    String name = "%im%";
    String phone = "%010%";
    List<Customer> list = customerRepository.findByNameLikeOrPhoneLikeOrderByNameDesc(name, phone);
    System.out.println("list = " + list);
  }
  
  @Test
  public void findById() {
    Long id = 1l;
    Optional<Customer> customer = customerRepository.findById(id);
    System.out.println("customer = " + customer);
    
  }
  
  @Test
  public void findByIdAndPhone() {
    Long id = 1l;
    String phone = "111";
    Optional<Customer> customer = customerRepository.findByIdAndPhone(id, phone);
    System.out.println("customer = " + customer);
    
  }
}
