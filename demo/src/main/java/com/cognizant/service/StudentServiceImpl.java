package com.cognizant.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cognizant.dao.AddressDao;
import com.cognizant.dao.StudentDao;
import com.cognizant.model.Address;
import com.cognizant.model.Student;


@Service
public class StudentServiceImpl implements StudentService {

	@Autowired
	private StudentDao studentDao;

	@Autowired
	private AddressDao addressDao;

	@Override
	public int create(Student student) {
		
		int add = addressDao.create(student.getAddress());
		int stu = studentDao.create(student);
		
		
		if (add > 0 && stu > 0) {
			return 1;
		} else {
			return 0;
		}
	}

	@Override
	public int update(Student student) {
		
		int upd=studentDao.update(student);
		if (upd > 0) {
			return 1;
		} else {
			return 0;
		}
	}

	@Override
	public int delete(int id) {
		int del=studentDao.delete(id);
		if (del > 0) {
			return 1;
		} else {
			return 0;
		}
	}

	@Override
	public List<Student> findAll() {

		List<Address> addresslist = addressDao.findAll();
		List<Student> studentList = studentDao.findAll();
		
		List<Student> finalList = new ArrayList<>();

		for (Student student : studentList) {
			if (student.getAddress().getHouseNo() == null) {
				student.getAddress().setHouseNo("-");
				student.getAddress().setCity("-");
			} else {
				for (Address add : addresslist) {
					if (add.getHouseNo().equals(student.getAddress().getHouseNo())) {
						student.getAddress().setCity(add.getCity());
						break;
					} 
				}
			}
			finalList.add(student);
		}
		return finalList;
	}
}

