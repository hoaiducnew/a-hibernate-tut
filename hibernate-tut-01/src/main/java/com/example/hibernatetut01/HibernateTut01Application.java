package com.example.hibernatetut01;

import java.util.Date;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.example.hibernatetut01.entity.Course;
import com.example.hibernatetut01.entity.Person;
import com.example.hibernatetut01.jpa.CourseRepository;
import com.example.hibernatetut01.jpa.PersonJpaRepository;

@SpringBootApplication
public class HibernateTut01Application implements CommandLineRunner {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	PersonJpaRepository repository;

	@Autowired
	private CourseRepository courseRepository;

	public static void main(String[] args) {
		SpringApplication.run(HibernateTut01Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		logger.info("User id 10001 -> {}", repository.findById(10001));
		repository.deleteById(10002);
		logger.info("Inserting 10004 -> {}", repository.insert(new Person("Tara", "Berlin", new Date())));
		logger.info("Updating 10003 -> {}", repository.update(new Person(10003, "Pieter", "Utrecht", new Date())));
		logger.info("All users -> {}", repository.findAll());

		Course course = courseRepository.findById(10001L);
		logger.info("Course 10001 -> {}", course);
	}
}
