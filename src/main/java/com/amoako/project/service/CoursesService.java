package com.amoako.project.service;

import java.util.List;

import com.amoako.project.entity.Courses;

public interface CoursesService 
{
	
	List <Courses> retrieveAllCourses();

	Courses saveCourses(Courses courses);
	
    Courses retrieveCoursesById(Long id);
	
	Courses updateCourses(Courses courses);
	
	void deleteCoursesById(Long id);


}
