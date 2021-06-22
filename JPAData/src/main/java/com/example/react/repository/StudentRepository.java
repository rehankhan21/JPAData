package com.example.react.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.react.model.Student;

// Jpa is the interface that is helping us communicate with hibernate
@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {
	
}
