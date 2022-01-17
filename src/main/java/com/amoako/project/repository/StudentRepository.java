package com.amoako.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amoako.project.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long>
{
	
	
}


