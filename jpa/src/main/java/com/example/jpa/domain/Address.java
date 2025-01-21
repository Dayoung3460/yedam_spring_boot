package com.example.jpa.domain;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@ToString
public class Address {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  private String zipCode;
  private String address;
  private String detail_address;
  
  @OneToOne
  // Customer entity랑 조인해서 만들어진 customer_id 칼럼(fk)
  @JoinColumn(name = "customer_id")
  Customer customer;
}
