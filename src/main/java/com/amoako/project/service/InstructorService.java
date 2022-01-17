package com.amoako.project.service;

import java.util.List;

import com.amoako.project.entity.Instructor;

public interface InstructorService 
{
	List <Instructor> retrieveAllInstructor();

	Instructor saveInstructor(Instructor instructor);
	
    Instructor retrieveInstructorById(Long id);
	
	Instructor updateInstructor(Instructor instructor);
	
	void deleteInstructorById(Long id);

}
