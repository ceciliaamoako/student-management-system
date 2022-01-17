package com.amoako.project.service;

import java.util.List;

import com.amoako.project.entity.Student;

public interface StudentService 
{
	List <Student> retrieveAllStudents();

	Student saveStudent(Student student);
	
    Student retrieveStudentById(Long id);
	
	Student updateStudent(Student student);
	
	void deleteStudentById(Long id);

}
