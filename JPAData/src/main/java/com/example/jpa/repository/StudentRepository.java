package com.example.jpa.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.example.jpa.execption.ResourceNotFoundException;
import com.example.jpa.model.Student;

// Jpa is the interface that is helping us communicate with hibernate
@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {
	
//	@Query("SELECT name From Student Where name = :name")
//	Student findStudentByName(@Param("name") String name);
	
	//Student findStudentByName(String name);
	
	//public static final List<Student> findByName = null;
	List<Student> findByName(String name);	
}
