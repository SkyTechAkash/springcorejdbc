package com.springcore.jdbc.dao;

import java.util.List;

import org.springcore.jdbc.entites.Student;

public interface StudentDao {
	
	public int insert(Student std);
	
	public int delete(int stdId);
	
	public int update(Student std);
	
	public Student findById(int stdId);
	
	public List<Student> findAll();

}
