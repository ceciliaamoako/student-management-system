package com.amoako.project.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="courses")
public class Courses 
{	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	
	@Column(name="subject")
	private String subject;
	
	@Column(name="number")
	private String number;
	
	@Column(name="title")
	private String title;
	
	@Column(name="credits")
	private String credits;
	
	@Column(name="location")
	private String location;
	
	@Column(name="daysOffered")
	private String daysOffered;
	
	
	@ManyToOne(cascade = {CascadeType.DETACH, 
			CascadeType.MERGE, 
			CascadeType.PERSIST, 
			CascadeType.REFRESH})	
	@JoinColumn(name="instructor_id")
	private Instructor instructor;
	
	//empty constructor
	public Courses() 
	{
		
	}
	
	public Courses( String subject, String number, String title, String credits, String location,
			String daysOffered, Instructor instructor) {
		super();
		this.subject = subject;
		this.number = number;
		this.title = title;
		this.credits = credits;
		this.location = location;
		this.daysOffered = daysOffered;
		this.instructor = instructor;
	}



	public Courses(String title) 
	{
		this.title = title;
	}


	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getTitle() 
	{
		return title;
	}

	public void setTitle(String title) 
	{
		this.title = title;
	}
	
	
	public String getSubject() {
		return subject;
	}


	public void setSubject(String subject)
	{
		this.subject = subject;
	}

	
	public String getNumber() 
	{
		return number;
	}

	
	public void setNumber(String number) 
	{
		this.number = number;
	}

	
	public String getCredits() {
		return credits;
	}

	
	public void setCredits(String credits)
	{
		this.credits = credits;
	}

	
	public String getLocation() {
		return location;
	}

	
	public void setLocation(String location) 
	{
		this.location = location;
	}

	
	public String getDaysOffered()
	{
		return daysOffered;
	}

	
	public void setDaysOffered(String daysOffered) 
	{
		this.daysOffered = daysOffered;
	}

	public Instructor getInstructor() 
	{
		return instructor;
	}

	public void setInstructor(Instructor instructor) 
	{
		this.instructor = instructor;
	}
	
	@Override
	public String toString() 
	{
		return "Course [id=" + id + ", title=" + title + "]";
	}
	

}
