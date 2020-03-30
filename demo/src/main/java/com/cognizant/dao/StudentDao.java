package com.cognizant.dao;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.cognizant.model.Student;

@Repository
public interface StudentDao {
	
	public int create(Student student);
	public int update(Student student);
	public int delete(int id);
	public List<Student> findAll();
}
