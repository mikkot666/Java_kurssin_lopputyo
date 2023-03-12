package com.mikkostudentproject.studentboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.mikkostudentproject.studentboot.models.Enrollment;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {
    
}
