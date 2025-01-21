package com.example.jpa.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

// JpaRepository:
// JpaRepository<Customer, Long> 타입과 타입의 pk type 넣어주면 됨
// 인터페이스
// 데이터베이스와 상호작용하는 데 필요한 기본적인 CRUD(Create, Read, Update, Delete) 기능을 자동으로 구현해줌
// 데이터를 페이징하고 정렬하는 기능 내장
public interface CustomerRepository extends JpaRepository<Customer, Long> {
  // Customer: table명이 아니고 entity클래스명
  @Query("select c from Customer c where id = ?1 order by name desc")
  public Optional<Customer> findById(Long id);
  
  @Query("select c from Customer c where id = :id and phone = :phone order by name desc")
  public Optional<Customer> findByIdAndPhone(@Param("id") Long id, @Param("phone") String phone);
  
  public List<Customer> findByNameLike(String keyword);
  public List<Customer> findByNameLikeOrPhoneLikeOrderByNameDesc(String name, String phone);
}

