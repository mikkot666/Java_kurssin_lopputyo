package com.mikkostudentproject.studentboot.service.impl;

import com.mikkostudentproject.studentboot.models.Course;
import com.mikkostudentproject.studentboot.repository.CourseRepository;
import com.mikkostudentproject.studentboot.service.CourseService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.*;


@Service
public class CourseServiceImpl implements CourseService {
    
    @Autowired
    private CourseRepository courseRepository;


    /*@Autowired
    public CourseServiceImpl(CourseRepository courseRepository) {
        this.courseRepository = courseRepository;
    }*/

    @Override
    public List<Course> getAllCourses() {
        return courseRepository.findAll();
    }

    @Override
    public Course createCourse(Course course) {
        return courseRepository.save(course);
    }

    @Override
    public Course getCourseById(Long courseId) {
        return courseRepository.findById(courseId).orElseThrow(() -> new RuntimeException("Kurssia ei löydy"));
    }

    @Override
    public Course updateCourse(Long courseId, Course course) {
        Course courseToUpdate = courseRepository.findById(courseId).orElseThrow();
        courseToUpdate.setName(course.getName());
        courseToUpdate.setCredits(course.getCredits());
        return courseRepository.save(courseToUpdate);
    }

    @Override
    public void deleteCourse(Long courseId) {
        courseRepository.deleteById(courseId);
    }
}
