package com.employeemanagement.repository.test;

import static org.assertj.core.api.Assertions.assertThat;

import javax.persistence.EntityManager;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import org.springframework.test.annotation.Rollback;

import com.employeemanagement.entity.Employee;
import com.employeemanagement.repository.EmployeeRepository;

@DataJpaTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
 public class EmployeeRepositoryTest {
	
//
//	
//	
//	@Autowired
//	private EntityManager entityManager;
//	   
//	@Autowired
//	private EmployeeRepository employeeRepository;
//	
//	@Test
//	@Order(1)
//	@Rollback(value = false)
//	 void addEmplyeeTest() {
//		Employee employee = new Employee(20, "aravind1234@gmail.com", "aravind", "88847", "1234", "admin", "management222",
//				"12345");
//
//		Employee emp=employeeRepository.save(employee);
////		assertThat(emp).isNotNull();
////		assertThat(emp.getEid()).isGreaterThan(0);
//		
//		Employee existUser = entityManager.find(Employee.class, emp.getEid());
//        assertThat(employee.getEid()).isEqualTo(existUser.getEid());
//
//
//	}
//	
//	@Test
//	@Order(2)
//	
//	public void findByEmailIdAndPasswordTest(){
//		Employee employee = new Employee(20, "aravind1234@gmail.com", "aravind", "88847", "1234", "admin", "management222",
//				"12345");				
//		//adminRepo.save(loan);
//		Employee emp = employeeRepository.findByEmailAndPassword("aravind1234@gmail.com","1234");
//		Assertions.assertThat(emp.getEid()).isGreaterThan(0);
//	}



}
