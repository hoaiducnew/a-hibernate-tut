package com.example.hibernatetut01.jpa;

import java.util.List;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.example.hibernatetut01.entity.Employee;
import com.example.hibernatetut01.entity.FullTimeEmployee;
import com.example.hibernatetut01.entity.PartTimeEmployee;

@Repository
@Transactional
public class EmployeeRepository {

	private Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	EntityManager em;

	public void insert(Employee employee) {
		em.persist(employee);
	}

//	public List<Employee> retrieveAllEmployees() {
//		return em.createQuery("select e from Employee e", Employee.class).getResultList();
//	}
//	
	public List<PartTimeEmployee> retrieveAllPartTimeEmployees() {
		return em.createQuery("select e from PartTimeEmployee e", PartTimeEmployee.class).getResultList();
	}
	
	public List<FullTimeEmployee> retrieveAllFullTimeEmployees() {
		return em.createQuery("select e from FullTimeEmployee e", FullTimeEmployee.class).getResultList();
	}
}