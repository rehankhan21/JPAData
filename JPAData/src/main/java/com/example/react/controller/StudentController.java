package com.example.react.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.react.model.Student;
import com.example.react.repository.StudentRepository;

@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("/api/")
public class StudentController {
	
	@Autowired
	private StudentRepository studentRepo;
	
	// get all students
	
	@GetMapping("/allstudents")
	public List<Student> getAllStudents() {
		return studentRepo.findAll()
;	}
}
