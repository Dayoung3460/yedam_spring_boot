package com.example.jpa.domain;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Data
// 데이터베이스의 테이블과 매핑
// @Entity가 선언된 클래스는 기본 생성자(파라미터 없는 생성자)가 반드시 필요
// @Entity 클래스는 반드시 @Id로 기본 키를 지정
@Entity
//@Table(name = "cust")
@AllArgsConstructor
@NoArgsConstructor
@Builder
@ToString
public class Customer {
//  기본 키(Primary Key)로 지정
  @Id
  // GenerationType.AUTO: JPA 구현체가 자동으로 적절한 전략을 선택(디비에 따라 시퀀스 쓸지 auto increment 쓸지 알아서 지정해줌)
  // GenerationType.IDENTITY: 데이터베이스의 AUTO_INCREMENT를 사용
  // GenerationType.SEQUENCE: 데이터베이스의 시퀀스를 사용
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  
  @Column(length = 20, nullable = false)
  private String name;
  
  @Column(length = 30, nullable = false, unique = true)
  private String phone;
  
  @OneToOne
  // Address entity랑 조인해서 만들어진 address_id 칼럼(fk)
  @JoinColumn(name = "address_id")
  Address address;
  
//  @OneToMany
//  @JoinColumn(name = "address_id")
//  List<Address> address;
  
  // lasting for only a short time; temporary:
  // db 컬럼 추가 안해줌
  @Transient
  private String addr;
  
  @Transient
  private String grade;
  
  public Customer(String name, String phone) {
    this.name = name;
    this.phone = phone;
  }
  
  
}
