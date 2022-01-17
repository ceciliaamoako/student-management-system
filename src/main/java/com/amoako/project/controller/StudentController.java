package com.amoako.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.amoako.project.entity.Student;
import com.amoako.project.service.StudentService;

@Controller
public class StudentController
{
	private StudentService studentService;

	public StudentController(StudentService studentService) 
	{
		super();
		this.studentService = studentService;
	}
	
	//handler method for retrieving students
	@GetMapping("/students")
	public String retrieveStudents(Model model)
	{
		model.addAttribute("students", studentService.retrieveAllStudents());
		return "students";
		
	}
	
	@GetMapping("/students/add")
	public String addStudentForm(Model model) 
	{
		
		Student student = new Student();
		model.addAttribute("student", student);
		return "add_student";
		
	}
	
	@PostMapping("/students")
	public String saveStudent(@ModelAttribute("student") Student student) 
	{
		studentService.saveStudent(student);
		return "redirect:/students";
	}
	
	
	@GetMapping("/students/edit/{id}")
	public String editStudentForm(@PathVariable Long id, Model model)
	{
		model.addAttribute("student", studentService.retrieveStudentById(id));
		return "edit_student";
	}

	@PostMapping("/students/{id}")
	public String updateStudent(@PathVariable Long id,
			@ModelAttribute("student") Student student,
			Model model)
	{
		
		// get student from database by id
		Student existingStudent = studentService.retrieveStudentById(id);
		
		existingStudent.setId(id);	
		existingStudent.setFirstName(student.getFirstName());
		existingStudent.setLastName(student.getLastName());
		existingStudent.setEmail(student.getEmail());
		existingStudent.setMajor(student.getMajor());
		existingStudent.setMinor(student.getMinor());
		existingStudent.setUndergradYear(student.getUndergradYear());
		
		
		// save updated student object
		studentService.updateStudent(existingStudent);
		return "redirect:/students";		
	}
	
	// handler method to handle delete student request
	@GetMapping("/students/{id}")
	public String deleteStudent(@PathVariable Long id) 
	{
		studentService.deleteStudentById(id);
		return "redirect:/students";
	}
	

}
