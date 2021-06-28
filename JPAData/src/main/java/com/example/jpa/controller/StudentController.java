package com.example.jpa.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.jpa.execption.ResourceNotFoundException;
import com.example.jpa.model.Student;
import com.example.jpa.repository.StudentRepository;

@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequestMapping("/api/")
public class StudentController {
	
	@Autowired
	private StudentRepository studentRepo;
	
	@GetMapping("/hi")
	public String hello() {
		return "Hello";
	}
	
	// get all students
	
	@GetMapping("/allstudents")
	public List<Student> getAllStudents() {
		return studentRepo.findAll();	
	}
	
	// addingg records. restapi methods is post for adding
	@PostMapping("/addstudent")
	public Student newStudent(@RequestBody Student s)
	{
		// .save is the jpa method for insert into
		return studentRepo.save(s);
	}
	
	@GetMapping("/student/{id}")
	public ResponseEntity<Student> getStudentById(@PathVariable int id){
		// the arrow function in java is called a lambda fucntion
		// error/expection handling
		Student s = studentRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Student not found"));
		return ResponseEntity.ok(s);
	}
	
	@GetMapping("/students/{name}")
//	@RequestMapping(method = RequestMethod.GET)
	public List<Student> getStudentByName(@PathVariable String name){
		//Student s = studentRepo.findStudentByName(name);
		//return ResponseEntity.ok(s);
			return studentRepo.findByName(name);
		
	}
	
	@PutMapping("/student/{id}")
	public ResponseEntity<Student> updateStudent(@PathVariable int id, @RequestBody Student student){
		
		Student s = studentRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Student not found"));
		s.setName(student.getName());
		s.setGrade(student.getGrade());
		Student updatedStudent = studentRepo.save(s);
		return ResponseEntity.ok(updatedStudent);
	}
	
	@DeleteMapping("/student/{id}")
	// local varaible maps with path variable
	public String deleteStudent(@PathVariable int id) {
		
		studentRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("Student not found"));
		studentRepo.deleteById(id);
		return "Student was deleted";
	}
}
