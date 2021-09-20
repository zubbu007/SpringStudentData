package com.cg.student.dto;

import java.util.Set;

public class StudentDetails {
	private Integer id;
	private String firstName;
	private String lastName;
	private Integer age;
	
	private Set<CourseDetails> courses;

	public StudentDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	public StudentDetails(Integer id, String firstName, String lastName, Integer age) {
	super();
	this.id = id;
	this.firstName = firstName;
	this.lastName = lastName;
	this.age = age;
}

	public StudentDetails(Integer id, String firstName, String lastName, Integer age, Set<CourseDetails> courses) {
		super();
		this.id = id;
		this.firstName = firstName;
		this.lastName = lastName;
		this.age = age;
		this.courses = courses;
	}

	@Override
	public String toString() {
		return "StudentDetails [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", age=" + age
				+ ", courses=" + courses + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Integer getAge() {
		return age;
	}

	public void setAge(Integer age) {
		this.age = age;
	}

	public Set<CourseDetails> getCourses() {
		return courses;
	}

	public void setCourses(Set<CourseDetails> courses) {
		this.courses = courses;
	}

}
