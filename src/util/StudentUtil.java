package com.cg.student.util;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.stereotype.Component;

import com.cg.student.dto.CourseDetails;
import com.cg.student.dto.StudentDetails;
import com.cg.student.entities.Course;
import com.cg.student.entities.Student;
@Component
public class StudentUtil {

	public StudentDetails toDetails(Student student) {
		Set<Course> courses=student.getCourses();
		Set<CourseDetails> details=new HashSet<>();
		for (Course course : courses) {
			details.add(new CourseDetails(course));
			
		}
		
		return new StudentDetails(student.getId(),student.getFirstName(),student.getLastName(),student.getAge(),details);
	}

	public List<StudentDetails> toDetails(List<Student> students) {
		 List<StudentDetails> detailList = new ArrayList<>();
	        for (Student student : students) {
	            StudentDetails details = toDetails(student);
	            System.out.println(details);
	            detailList.add(details);
	        }
	        return detailList;
	
	}

}
