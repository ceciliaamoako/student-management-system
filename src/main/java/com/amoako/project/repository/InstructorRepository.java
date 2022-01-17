package com.amoako.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amoako.project.entity.Instructor;

public interface InstructorRepository extends JpaRepository<Instructor, Long>
{

}
