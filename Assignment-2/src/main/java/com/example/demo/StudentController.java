package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
@RequestMapping("/studentportal")
public class StudentController {

	@Autowired
	StudentService studentService;
	
	@RequestMapping(method=RequestMethod.GET,value="create")
	public ModelAndView createStudent(ModelAndView mandv) {
		Student dto=new Student();
		mandv.addObject("student",dto);
		mandv.setViewName("studentdata");
		return mandv;
	}

	 
	@RequestMapping(method = RequestMethod.POST,value="create")
	public void createStudent(Student student) {
		// TODO Auto-generated method stub
		studentService.createStudent(student);
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/findall")
	public List<Student> findAll() {
		// TODO Auto-generated method stub
		return studentService.findAll();
		
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/findbyid/{rollnumber}")
	public Student getRollNo(@PathVariable("rollnumber") int id) {
		// TODO Auto-generated method stub
		return studentService.getRollNo(id);
	}
	
	@RequestMapping(method = RequestMethod.GET, value="/deletebyid/{rollnumber}")
	public void deleteById(@PathVariable("rollnumber") int id) {
		studentService.deleteStudentById(id);
	}

}
