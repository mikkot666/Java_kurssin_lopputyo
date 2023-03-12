package com.mikkostudentproject.studentboot.service;

import org.springframework.stereotype.Service;

import com.mikkostudentproject.studentboot.models.Course;
import com.mikkostudentproject.studentboot.models.Enrollment;

import java.util.List;

@Service
public interface EnrollmentService {
    List<Enrollment> getAllEnrollments();
    Enrollment getEnrollmentById(Long id);
    Enrollment addStudentToCourse(Long studentId, Long courseId);
    void removeEnrollment(Long id);
}
