package com.mikkostudentproject.studentboot.controller;

import com.mikkostudentproject.studentboot.models.Course;
import com.mikkostudentproject.studentboot.models.Enrollment;
import com.mikkostudentproject.studentboot.service.EnrollmentService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping("/enrollments")
public class EnrollmentRestController {

    @Autowired
    private EnrollmentService enrollmentService;

    @GetMapping("/{enrollmentId}")
    public ResponseEntity<Enrollment> getEnrollmentById(@PathVariable Long enrollmentId) {
        Enrollment enrollment = enrollmentService.getEnrollmentById(enrollmentId);
        return ResponseEntity.ok(enrollment);
    }

    @GetMapping("")
    public ResponseEntity<List<Enrollment>> getAllEnrollments() {
        List<Enrollment> enrollments = enrollmentService.getAllEnrollments();
        return ResponseEntity.ok(enrollments);
    }

    @PostMapping("/{courseId}/students/{studentId}")
    public ResponseEntity<Enrollment> addStudentToCourse(@PathVariable Long courseId, @PathVariable Long studentId) {
        Enrollment enrollment = enrollmentService.addStudentToCourse(studentId, courseId);
        if (enrollment == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok(enrollment);
    }

    @DeleteMapping("/{enrollmentId}")
    public ResponseEntity<Void> removeEnrollment(@PathVariable Long enrollmentId) {
        enrollmentService.removeEnrollment(enrollmentId);
        return ResponseEntity.noContent().build();
    }
}
