package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("student")
public class StudentService implements SutdentServiceInterface{
	@Autowired
	private StudentDAO dao;

	@Override
	public void createStudent(Student student) {
		// TODO Auto-generated method stub
		dao.save(student);
		
	}

	@Override
	public Student getRollNo(int id) {
		// TODO Auto-generated method stub
		Optional<Student> obj = dao.findById(Integer.valueOf(id));
		Student student = obj.get();
		return student;
		
	}

	@Override
	public List<Student> findAll() {
		// TODO Auto-generated method stub
		List<Student> list = dao.findAll();
		return list;
	}

	@Override
	public void deleteStudentById(int id) {
		// TODO Auto-generated method stub
		dao.deleteById(id);
	}
	

}
