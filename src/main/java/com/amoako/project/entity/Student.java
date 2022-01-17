package com.amoako.project.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class Student 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(name = "first_name")
	private String firstName;
	
	@Column(name = "last_name", nullable = false)
	private String lastName;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "major")
	private String major;
	
	@Column(name = "minor")
	private String minor;
	
	@Column(name = "undergrad_year")
	private String undergradYear;
	
	// Empty constructor
	public Student()
	{
		
	}
			
	public Student(String firstName, String lastName, String email, String major, String minor, String undergradYear) 
	{
		super();
		this.firstName = firstName;
		this.lastName = lastName;
		this.email = email;
		this.major = major;
		this.minor = minor;
		this.undergradYear = undergradYear;
	}
	
	/**
	 * @return the id
	 */
	public Long getId() {
		return id;
	}
	 /**
	 * @param id the id to set
	 */
	public void setId(Long id) {
		this.id = id;
	}
	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}
	/**
	 * @param firstName the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}
	/**
	 * @param lastName the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return the major
	 */
	public String getMajor() {
		return major;
	}
	/**
	 * @param major the major to set
	 */
	public void setMajor(String major) {
		this.major = major;
	}
	/**
	 * @return the minor
	 */
	public String getMinor() {
		return minor;
	}
	/**
	 * @param minor the minor to set
	 */
	public void setMinor(String minor) {
		this.minor = minor;
	}
	/**
	 * @return the undergradYear
	 */
	public String getUndergradYear() {
		return undergradYear;
	}
	/**
	 * @param undergradYear the undergradYear to set
	 */
	public void setUndergradYear(String undergradYear) {
		this.undergradYear = undergradYear;
	}
	
	
	

}
