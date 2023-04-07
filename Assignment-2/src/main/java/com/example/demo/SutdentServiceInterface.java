package com.example.demo;

import java.util.List;

public interface SutdentServiceInterface {
	public void createStudent(Student student);
	public Student getRollNo(int id);
	public List<Student> findAll();
	public void deleteStudentById(int id);
}
