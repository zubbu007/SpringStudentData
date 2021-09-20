package com.cg.student.controller;

import java.util.List;
import java.util.Set;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.cg.student.dto.CreateStudentRequest;
import com.cg.student.dto.StudentDetails;
import com.cg.student.entities.Course;
import com.cg.student.entities.Student;
import com.cg.student.service.IStudentService;
import com.cg.student.util.StudentUtil;
import org.springframework.http.HttpStatus;


@RestController
@RequestMapping("/students")
@Validated
public class StudentControlller {
	@Autowired
	private IStudentService service;
	
	@Autowired
	private StudentUtil studentUtil;
	
	@GetMapping("/by/id/{id}")
	public StudentDetails fetchStudent(@PathVariable("id") Integer id) {
		System.out.println("controller fetch id: "+id);
		Student student=service.findById(id);
		StudentDetails details=studentUtil.toDetails(student);
		System.out.println("details: "+details);
		return details;
		
	}
	
	@GetMapping("/by/name/{name}")
	public List<StudentDetails> fetchStudentByName(@PathVariable("name") String name) {
		System.out.println("cntrlr fetch name: " + name);
		List<Student> students = service.findByName(name);
		List<StudentDetails> response = studentUtil.toDetails(students);
		System.out.println("by name details: " + response);
		return response;
	}
	@GetMapping
	public List<StudentDetails> fetchAll(){
		List<Student> students=service.findAll();
		List<StudentDetails> response=studentUtil.toDetails(students);
		return response;
		
	}
	@GetMapping("/by/name/{fname}/{lname}")
	public List<StudentDetails> fetchStudentByFullName(@PathVariable("fname") String fname,
			@PathVariable("lname") String lname) {
		System.out.println("cntrlr fetch name: " + fname + " " + lname);
//		 List<Student> students = service.findByFullName(fname,lname);
		List<Student> students = service.findByFirstNameAndLastName(fname, lname);
		List<StudentDetails> response = studentUtil.toDetails(students);
		System.out.println("by name details: " + response);
		return response;
	}

	@ResponseStatus(HttpStatus.CREATED)
	@PostMapping("/add")
	public StudentDetails add(@RequestBody @Valid CreateStudentRequest requestData) {
		System.out.println("req data: " + requestData);
		Student student = new Student(requestData.getFirstName(), requestData.getLastName(), requestData.getAge());
		Set<Course> coursSet = requestData.getCourses();
		if (coursSet != null) {
			for (Course course : coursSet) {
				student.addCourse(course);
			}
		}
		System.out.println("stud came: " + student);
		student = service.register(student);
		StudentDetails details = studentUtil.toDetails(student);
		return details;
	}
	
	
}
