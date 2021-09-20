package com.cg.student.service;

import java.util.List;

import com.cg.student.entities.Student;

public interface IStudentService {

	Student findById(Integer id);

	List<Student> findAll();

	List<Student> findByName(String name);

	List<Student> findByFullName(String fname, String lname);

	List<Student> findByFirstNameAndLastName(String fname, String lname);

	Student register(Student student);

}
