package com.mikkostudentproject.studentboot.repository;

import java.util.*;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.mikkostudentproject.studentboot.models.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

}
