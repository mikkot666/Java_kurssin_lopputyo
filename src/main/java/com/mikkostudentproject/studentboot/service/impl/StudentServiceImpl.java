package com.mikkostudentproject.studentboot.service.impl;

import com.mikkostudentproject.studentboot.models.Student;
import com.mikkostudentproject.studentboot.repository.StudentRepository;
import com.mikkostudentproject.studentboot.service.StudentService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;


@Service
@Transactional
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentRepository studentRepository;
    

    /*@Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }*/

    @Override
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    @Override
    public Student createStudent(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student getStudentById(Long id) {
        return studentRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Opiskelijaa ei löydy"));
    }  

    @Override
    public void deleteStudent(Long id) {
        studentRepository.deleteById(id);
    }
}
