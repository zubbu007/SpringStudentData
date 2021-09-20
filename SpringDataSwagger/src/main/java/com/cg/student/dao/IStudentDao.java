package com.cg.student.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.cg.student.entities.Student;

public interface IStudentDao extends JpaRepository<Student,Integer> {

	List<Student> findByFirstName(String name);
	
	@Query("from Student where firstName=:fname and lastName=:lname")
	List<Student> findByFullName(@Param("fname") String firstName, @Param("lname") String lastName);

	List<Student> findByFirstNameAndLastName( @Param("firstName") String firstName, @Param("lastName") String lastName);
}
