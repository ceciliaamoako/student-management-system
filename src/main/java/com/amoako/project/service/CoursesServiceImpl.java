package com.amoako.project.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.amoako.project.entity.Courses;
import com.amoako.project.repository.CoursesRepository;

@Service
public class CoursesServiceImpl implements CoursesService
{
	
	private CoursesRepository coursesRepository;
	
	
	public CoursesServiceImpl(CoursesRepository coursesRepository)
	{
		super();
		this.coursesRepository = coursesRepository;
	}

	@Override
	public List<Courses> retrieveAllCourses() 
	{
		
		return coursesRepository.findAll();
	}

	@Override
	public Courses saveCourses(Courses courses) 
	{	
		return coursesRepository.save(courses);
	}

	@Override
	public Courses retrieveCoursesById(Long id)
	{
		return coursesRepository.findById(id).get();
	}

	@Override
	public Courses updateCourses(Courses courses) 
	{
		
		return coursesRepository.save(courses);
	}

	@Override
	public void deleteCoursesById(Long id) 
	{
		coursesRepository.deleteById(id);
		
	}
	

}
