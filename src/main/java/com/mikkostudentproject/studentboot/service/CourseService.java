package com.mikkostudentproject.studentboot.service;

import com.mikkostudentproject.studentboot.models.Course;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface CourseService {
    List<Course> getAllCourses();
    Course getCourseById(Long id);
    Course createCourse(Course course);
    Course updateCourse(Long id, Course course);
    void deleteCourse(Long id);
}