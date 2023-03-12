package com.mikkostudentproject.studentboot.service;

import com.mikkostudentproject.studentboot.models.Student;

import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface StudentService {
    List<Student> getAllStudents();
    Student getStudentById(Long id);
    Student createStudent(Student student);
    void deleteStudent(Long id);
}