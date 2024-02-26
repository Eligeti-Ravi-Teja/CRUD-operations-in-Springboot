package com.jsp.projectStudent.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.jsp.projectStudent.entity.Student;

public interface StudentRepo extends JpaRepository<Student, Integer>{
	@Query("select e from Student e where email=?1")
	public Student fetchByEmail(String email);
}
