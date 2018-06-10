package com.example.hibernatetut01;

import java.math.BigDecimal;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.hibernatetut01.entity.FullTimeEmployee;
import com.example.hibernatetut01.entity.PartTimeEmployee;
import com.example.hibernatetut01.jpa.CourseRepository;
import com.example.hibernatetut01.jpa.EmployeeRepository;
import com.example.hibernatetut01.jpa.PersonRepository;
import com.example.hibernatetut01.jpa.StudentRepository;

@SpringBootApplication
public class HibernateTut01Application implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	private PersonRepository personRepository;

	@Autowired
	private CourseRepository courseRepository;
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private EmployeeRepository employeeRepository;

	public static void main(String[] args) {
		SpringApplication.run(HibernateTut01Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
//		logger.info("User id 10001 -> {}", personRepository.findById(10001));
//		personRepository.deleteById(10002);
//		logger.info("Inserting 10004 -> {}", personRepository.insert(new Person("Tara", "Berlin", new Date())));
//		logger.info("Updating 10003 -> {}", personRepository.update(new Person(10003, "Pieter", "Utrecht", new Date())));
//		logger.info("All users -> {}", personRepository.findAll());
//
//		Course course = courseRepository.findById(10001L);
//		logger.info("Course 10001 -> {}", course);
		
//		courseRepository.deleteById(10001L);
		
//		courseRepository.save(new Course("Microservices in 100 Steps"));
//		
//		courseRepository.playWithEntityManager();
//		studentRepository.saveStudentWithPassport();
		
//		courseRepository.addHardcodedReviewsForCourse();
//		List<Review> reviews = new ArrayList<>();
//		
//		reviews.add(new Review("5", "Great Hands-on Stuff."));	
//		reviews.add(new Review("5", "Hatsoff."));
//
//		courseRepository.addReviewsForCourse(10003L, reviews);
		
//		studentRepository.insertStudentAndCourse(new Student("Jack"), new Course("Microservices in 100 Steps"));
		
		// Jack FullTimeEmployee salary - 10000$
		// Jill PartTimeEmployee - 50$ per hour
		employeeRepository.insert(new PartTimeEmployee("Jill", new BigDecimal("50")));
		employeeRepository.insert(new FullTimeEmployee("Jack", new BigDecimal("10000")));

		logger.info("All Part Time Employees -> {}", employeeRepository.retrieveAllPartTimeEmployees());
		logger.info("All Full Time Employees -> {}", employeeRepository.retrieveAllFullTimeEmployees());
	}
}
