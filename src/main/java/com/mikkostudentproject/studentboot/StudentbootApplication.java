package com.mikkostudentproject.studentboot;


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;



@SpringBootApplication(/*exclude = {DataSourceAutoConfiguration.class}*/)
@EnableJpaRepositories(basePackages = "com.mikkostudentproject.studentboot.repository")
@EntityScan(basePackages = "com.mikkostudentproject.studentboot.models")
public class StudentbootApplication {

	public static void main(String[] args) {
		SpringApplication.run(StudentbootApplication.class, args);
	}

}
