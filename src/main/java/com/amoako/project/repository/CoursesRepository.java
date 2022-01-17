package com.amoako.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.amoako.project.entity.Courses;

public interface CoursesRepository extends JpaRepository<Courses, Long>
{

}
