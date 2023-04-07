package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("student")
public class StudentService implements SutdentServiceInterface{
	@Autowired
	private StudentDAO studentDAO;

	@Override
	public void createStudent(Student student) {
		// TODO Auto-generated method stub
		studentDAO.save(student);
		
	}

	@Override
	public Student getRollNo(int id) {
		// TODO Auto-generated method stub
		Optional<Student> getStudentRollNo = studentDAO.findById(Integer.valueOf(id));
		Student student = getStudentRollNo.get();
		return student;
		
	}

	@Override
	public List<Student> findAll() {
		// TODO Auto-generated method stub
		List<Student> studentList = studentDAO.findAll();
		return studentList;
	}

	@Override
	public void deleteStudentById(int id) {
		// TODO Auto-generated method stub
		studentDAO.deleteById(id);
	}
	

}
