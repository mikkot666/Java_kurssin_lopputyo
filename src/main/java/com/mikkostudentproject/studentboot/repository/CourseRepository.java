package com.mikkostudentproject.studentboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mikkostudentproject.studentboot.models.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Long>  {
   
}
