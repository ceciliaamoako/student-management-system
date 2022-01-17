package com.amoako.project.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.amoako.project.entity.Instructor;
import com.amoako.project.repository.InstructorRepository;

@Service
public class InstructorServiceImp implements InstructorService
{
	
	private InstructorRepository instructorRepository;
	

	public InstructorServiceImp(InstructorRepository instructorRepository)
	{
		super();
		this.instructorRepository = instructorRepository;
	}

	@Override
	public List<Instructor> retrieveAllInstructor() 
	{
		return instructorRepository.findAll();
	}

	@Override
	public Instructor saveInstructor(Instructor instructor) 
	{
		return instructorRepository.save(instructor);
	}

	@Override
	public Instructor retrieveInstructorById(Long id) 
	{
		return instructorRepository.findById(id).get();
	}

	@Override
	public Instructor updateInstructor(Instructor instructor) 
	{
		return instructorRepository.save(instructor);
	}

	@Override
	public void deleteInstructorById(Long id) 
	{
		instructorRepository.deleteById(id);
		
	}

}
