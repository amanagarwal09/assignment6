package com.cognizant.service;

import java.util.List;

import com.cognizant.model.Student;

public interface StudentService {

	public int create(Student student);

	public int update(Student student);

	public List<Student> findAll();

	public int delete(int id);

}
