package com.example.spring_basic.repository;

import com.example.spring_basic.Entity.JoinEntity;
import org.springframework.data.jpa.repository.JpaRepository;

//JPA 인터페이스만 정의
//이때 JpaRepository를 상속하면서 전달되는 데이터를 JoinEntity내용으로 강제
public class JoinRepo extends JpaRepository<JoinEntity, Long> {
}
