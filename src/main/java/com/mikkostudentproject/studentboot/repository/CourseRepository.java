package com.mikkostudentproject.studentboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mikkostudentproject.studentboot.models.Course;

public interface CourseRepository extends JpaRepository<Course, Long>  {
   
}
