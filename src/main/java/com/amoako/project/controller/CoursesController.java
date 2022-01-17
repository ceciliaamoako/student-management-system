package com.amoako.project.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.amoako.project.entity.Courses;
import com.amoako.project.service.CoursesService;

@Controller
public class CoursesController
{
	private CoursesService coursesService;

	public CoursesController(CoursesService coursesService) 
	{
		super();
		this.coursesService = coursesService;
	}
	
	    //handler method for retrieving students
		@GetMapping("/courses")
		public String retrieveCourses(Model model)
		{
			model.addAttribute("courses", coursesService.retrieveAllCourses());
			return "courses";
			
		}
		
		@PostMapping("/courses")
		public String saveCourses(@ModelAttribute("courses") Courses courses) 
		{
			coursesService.saveCourses(courses);
			return "redirect:/courses";
		}
		
		@GetMapping("/courses/add")
		public String addCoursesForm(Model model) 
		{
			
			Courses courses = new Courses();
			model.addAttribute("courses", courses);
			return "add_courses";
			
		}
		
			
		@GetMapping("/courses/edit/{id}")
		public String editCoursesForm(@PathVariable Long id, Model model)
		{
			model.addAttribute("courses", coursesService.retrieveCoursesById(id));
			return "edit_courses";
		}

		@PostMapping("/courses/{id}")
		public String updateCourses(@PathVariable Long id,
				@ModelAttribute("courses") Courses courses,
				Model model)
		{
			
			// get course from database by id
			Courses existingCourse = coursesService.retrieveCoursesById(id);
			
			existingCourse.setId(id);	
			existingCourse.setSubject(courses.getSubject());
			existingCourse.setNumber(courses.getNumber());
			existingCourse.setTitle(courses.getTitle());
			existingCourse.setCredits(courses.getCredits());
			existingCourse.setLocation(courses.getLocation());
			existingCourse.setDaysOffered(courses.getDaysOffered());
			
			
			coursesService.updateCourses(existingCourse);
			return "redirect:/courses";		
		}
		
		// handler method to handle delete courses request
		@GetMapping("/courses/{id}")
		public String deleteCourses(@PathVariable Long id) 
		{
			coursesService.deleteCoursesById(id);
			return "redirect:/courses";
		}
		
	
	

}
