package com.mikkostudentproject.studentboot.models;

import java.util.*;

import javax.persistence.*;
import javax.validation.constraints.*;

@Entity
@Table(name = "courses")
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Kurssin nimi on pakollinen")
    private String name;

    private double credits;

    @OneToMany
    private List<Enrollment> enrollments = new ArrayList<>();


    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCredits() {
        return this.credits;
    }

    public void setCredits(double credits) {
        this.credits = credits;
    }

    public List<Enrollment> getEnrollments() {
        return this.enrollments;
    }

    public void setEnrollments(List<Enrollment> enrollments) {
        this.enrollments = enrollments;
    }


}
