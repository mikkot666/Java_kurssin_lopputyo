package com.mikkostudentproject.studentboot.service.impl;

import java.time.LocalDateTime;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mikkostudentproject.studentboot.models.Course;
import com.mikkostudentproject.studentboot.models.Enrollment;
import com.mikkostudentproject.studentboot.models.Student;
import com.mikkostudentproject.studentboot.repository.CourseRepository;
import com.mikkostudentproject.studentboot.repository.EnrollmentRepository;
import com.mikkostudentproject.studentboot.repository.StudentRepository;
import com.mikkostudentproject.studentboot.service.EnrollmentService;

@Service
public class EnrollmentServiceImpl implements EnrollmentService {
    
    @Autowired
    private EnrollmentRepository enrollmentRepository;

    @Autowired
    private CourseRepository courseRepository;

    @Autowired
    private StudentRepository studentRepository;

    @Override
    public List<Enrollment> getAllEnrollments() {
        return enrollmentRepository.findAll();
    }

    @Override
    public Enrollment getEnrollmentById(Long id) {
        return enrollmentRepository.findById(id).orElse(null);
    }

    @Override
    public Enrollment addStudentToCourse(Long studentId, Long courseId) {
        Student student = studentRepository.findById(studentId).orElse(null);
        Course course = courseRepository.findById(courseId).orElse(null);

        if (student == null || course == null) {
            return null;
        }

        Enrollment enrollment = new Enrollment();
        enrollment.setStudent(student);
        enrollment.setCourse(course);

        return enrollmentRepository.save(enrollment);
    }

    @Override
    public void removeEnrollment(Long id) {
        enrollmentRepository.deleteById(id);
    }
}
