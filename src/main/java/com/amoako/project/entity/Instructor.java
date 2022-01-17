package com.amoako.project.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name="instructor")
public class Instructor 
{
	
	
	@OneToMany(fetch = FetchType.LAZY, mappedBy="instructor",
				cascade= {CascadeType.DETACH,CascadeType.MERGE, 
						 CascadeType.PERSIST, CascadeType.REFRESH})
	private List<Courses> courses;
	

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private Long id;

	@Column(name="first_name")
	private String firstName;

	@Column(name="last_name")
	private String lastName;

	@Column(name="email")
	private String email;
	
	@Column(name="office")
	private String office;
	
	public Instructor(String firstName, String lastName, String email) 
	{
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		
	}
	
	public Instructor()
	{
		super();
	}
	
		
		public Long getId() 
		{
			return id;
		}

		public void setId(Long id)
		{
			this.id = id;
		}

		public String getFirstName()
		{
			return firstName;
		}

		public void setFirstName(String firstName) 
		{
			this.firstName = firstName;
		}

		public String getLastName() 
		{
			return lastName;
		}

		public void setLastName(String lastName) 
		{
			this.lastName = lastName;
		}

		public String getEmail() 
		{
			return email;
		}

		public void setEmail(String email) 
		{
			this.email = email;
		}
		
		
		public String getOffice() {
			return office;
		}

		
		public void setOffice(String office) {
			this.office = office;
		}

		public List<Courses> getCourses() 
		{
			return courses;
		}

		public void setCourses(List<Courses> courses) 
		{
			this.courses = courses;
		}
		
		
		public void add(Courses tempCourse) 
		{
			if (courses==null) 
			{
				courses = new ArrayList<>();
			}
			courses.add(tempCourse);
			tempCourse.setInstructor(this);
		}
}

	