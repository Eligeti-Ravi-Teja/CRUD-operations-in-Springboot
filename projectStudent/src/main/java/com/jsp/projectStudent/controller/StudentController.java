package com.jsp.projectStudent.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.jsp.projectStudent.entity.Student;
import com.jsp.projectStudent.service.StudentService;
import com.jsp.projectStudent.util.ResponseStructure;

@RestController
public class StudentController {
	@Autowired
	StudentService service;
	
	@PostMapping("/register")
	public ResponseEntity<ResponseStructure<Student>> register(@RequestBody Student student){
		return service.register(student);
	}
	
	@GetMapping("/login")
	public ResponseEntity<ResponseStructure<Student>> login(@RequestBody Student student){
		return service.login(student);
	}
	
	@PutMapping("/update")
	public ResponseEntity<ResponseStructure<Student>> update(@RequestBody Student student){
		return service.update(student);
	}

	@DeleteMapping("/delete")
	public ResponseEntity<ResponseStructure<Student>> delete(@RequestBody Student student){
		return service.delete(student);
	}
}
