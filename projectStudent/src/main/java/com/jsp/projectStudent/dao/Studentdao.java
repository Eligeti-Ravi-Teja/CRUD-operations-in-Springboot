package com.jsp.projectStudent.dao;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.jsp.projectStudent.entity.Student;
import com.jsp.projectStudent.repo.StudentRepo;

@Repository
public class Studentdao {
	@Autowired
	StudentRepo repo;
//	registration 
	public Student registerStudent(Student student) {
		Student db = repo.fetchByEmail(student.getEmail());
		System.out.println(db);
	    if(db==null) {
	 	  return repo.save(student);
	    }
	    else {
		   return null;
	    }  
   }
	
//	update
	public Student updateStudent(Student student) {
		Optional<Student> data = repo.findById(student.getId());
//		System.out.println(data.get());
		if(data.isPresent()) {
		  return repo.save(student);
		}
		else {
			return null;
		}
		
		
	}
	
//	login
	public Student login(String email) {
		return repo.fetchByEmail(email);
	}
	
//fetchByemail
	public Student fetchById(int id) {
		return repo.findById(id).get();
	}
	
//delete
	public Student delete(int id) {
		Optional<Student> data = repo.findById(id);
		if(data.isPresent()) {
			System.out.println("coming.....................");
			repo.delete(data.get());
			return data.get();
		}
		else {
			return null;
		}
		
	}
	

}
