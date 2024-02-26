package com.jsp.projectStudent.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

import com.jsp.projectStudent.dao.Studentdao;
import com.jsp.projectStudent.entity.Student;
import com.jsp.projectStudent.exception.EmailAlreadyExist;
import com.jsp.projectStudent.exception.EmailDoesNotExist;
import com.jsp.projectStudent.exception.IncorrectPassword;
import com.jsp.projectStudent.util.ResponseStructure;

@Service
public class StudentService {
	@Autowired
	Studentdao dao;
		@Autowired
		JavaMailSender mailSender;
		public ResponseEntity<ResponseStructure<Student>> register(Student student){
		Student st = dao.registerStudent(student);
		if(st!=null) {
//			-----------------------------------------------
			SimpleMailMessage mail=new SimpleMailMessage();
			mail.setFrom("eligetiraviteja267@gmail.com");
			mail.setTo(student.getEmail());
			mail.setText("Thank you "+student.getName() +" for registering to our website");
			mail.setSubject("Registration successfull to myapp");
			mailSender.send(mail);
//			-----------------------------------------------------
			ResponseStructure<Student> rs= new ResponseStructure<Student>();
			rs.setMessage("Registration successfull!!");
			rs.setStatus(HttpStatus.CREATED.value());
			rs.setData(st);
			return new ResponseEntity<ResponseStructure<Student>>(rs,HttpStatus.CREATED);
		}
		else {
			throw new EmailAlreadyExist("Email "+student.getEmail()+" already registered");
		}
	}
//	---------------------------------------------------------------------------------
//	login----------------------------------------------------------------------
		public ResponseEntity<ResponseStructure<Student>> login(Student student){
			Student s=dao.login(student.getEmail());
			if(s==null) {
				throw new EmailDoesNotExist("Email "+student.getEmail()+" is not found.");
			}
			else {
				if(s.getPassword().equals(student.getPassword())) {
					ResponseStructure<Student> rs=new ResponseStructure<Student>();
					rs.setMessage("Login succesful");
					rs.setData(s);
					rs.setStatus(HttpStatus.ACCEPTED.value());
					return new ResponseEntity<ResponseStructure<Student>>(rs,HttpStatus.ACCEPTED);
					
					
				}
				else {
//					System.out.println(student.getPassword());
					throw new IncorrectPassword("Incorrect password");
					
				}
			}
		}
		
//----------------------------------------------------------------------------------------
//		update------------------------------------------------
		public ResponseEntity<ResponseStructure<Student>> update(Student student){
			Student s=dao.login(student.getEmail());
			if(s==null) {
				throw new EmailDoesNotExist("You cant change your email");
			}
			else {
				if(student.getId()==0) {
					student.setId(s.getId());				}
				if(student.getName()==null) {
					student.setName(s.getName());
				}
				if(student.getEmail()==null) {
					student.setEmail(s.getEmail());
				}
				if(student.getPassword()==null) {
					student.setPassword(s.getPassword());
				}
				if(student.getMobile()==0) {
					student.setMobile(s.getMobile());
				}
				if(student.getAddress()==null) {
					student.setAddress(s.getAddress());
				}
				if(student.getGender()==null) {
					student.setGender(s.getGender());
				}
				Student a = dao.updateStudent(student);
				ResponseStructure<Student> rs=new ResponseStructure<Student>();
				rs.setData(a);
				rs.setMessage("updated succesfully");
				rs.setStatus(HttpStatus.ACCEPTED.value());
				return new ResponseEntity<ResponseStructure<Student>>(rs,HttpStatus.ACCEPTED);
				
			}
		}
//		===========================================================
//		delete =======================================================
		
		public ResponseEntity<ResponseStructure<Student>> delete(Student student){
			Student data = dao.login(student.getEmail());
			if(data==null) {
				throw new EmailDoesNotExist("Data incorrect");
			}
			else {
				Student s = dao.delete(data.getId());
				System.out.println(s);
				ResponseStructure<Student> rs=new ResponseStructure<Student>();
				rs.setData(data);
				rs.setMessage("Credentials are deleted");
				rs.setStatus(HttpStatus.ACCEPTED.value());
				return new ResponseEntity<ResponseStructure<Student>>(rs,HttpStatus.ACCEPTED);
			}
		}
}
