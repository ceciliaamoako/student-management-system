package com.amoako.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.amoako.project.entity.Instructor;
import com.amoako.project.service.InstructorService;


@Controller
public class InstructorController 
{
	private InstructorService instructorService;
	
	public InstructorController(InstructorService instructorService) 
	{
		super();
		this.instructorService = instructorService;
	}
	
	//handler method for retrieving students
	@GetMapping("/instructor")
	public String retrieveInstructor(Model model)
	{
		model.addAttribute("instructor", instructorService.retrieveAllInstructor());
		return "instructor";
		
	}
	
	@GetMapping("/instructor/add")
	public String addInstructorForm(Model model) 
	{
		Instructor instructor = new Instructor();
		model.addAttribute("instructor", instructor);
		return "add_instructor";
		
	}
	
	@PostMapping("/instructor")
	public String saveInstructor(@ModelAttribute("instructor") Instructor instructor) 
	{
		instructorService.saveInstructor(instructor);
		return "redirect:/instructor";
	}
	
	
	@GetMapping("/instructor/edit/{id}")
	public String editInstructorForm(@PathVariable Long id, Model model)
	{
		model.addAttribute("instructor", instructorService.retrieveInstructorById(id));
		return "edit_instructor";
	}

	@PostMapping("/instructor/{id}")
	public String updateInstructor(@PathVariable Long id,
			@ModelAttribute("instructor") Instructor instructor, Model model)
	{
		
		// get instructor from database by id
		Instructor existingInstructor = instructorService.retrieveInstructorById(id);
		
		existingInstructor.setId(id);	
		existingInstructor.setFirstName(instructor.getFirstName());
		existingInstructor.setLastName(instructor.getLastName());
		existingInstructor.setEmail(instructor.getEmail());
		existingInstructor.setOffice(instructor.getOffice());
			
		// save updated instructor object
		instructorService.updateInstructor(existingInstructor);
		return "redirect:/instructor";		
	}
	
	// handler method to handle delete student request
	@GetMapping("/instructor/{id}")
	public String deleteInstructor(@PathVariable Long id) 
	{
		instructorService.deleteInstructorById(id);
		return "redirect:/instructor";
	}

}
