package com.mikkostudentproject.studentboot.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.mikkostudentproject.studentboot.models.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {

}
