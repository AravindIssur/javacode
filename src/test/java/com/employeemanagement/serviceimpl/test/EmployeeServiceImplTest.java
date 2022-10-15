package com.employeemanagement.serviceimpl.test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.employeemanagement.entity.Employee;
import com.employeemanagement.repository.EmployeeRepository;
import com.employeemanagement.responsemodel.ResponseModel;
import com.employeemanagement.serviceimpl.EmployeeServiceImpl;

@ExtendWith(MockitoExtension.class)
 class EmployeeServiceImplTest {

	@Mock
	private EmployeeRepository employeeRepository;

	@InjectMocks
	private EmployeeServiceImpl employeeServiceImpl;

	@MockBean
	private Employee employee;

	

	@Test
	void addEmployeeTest() throws Exception {
		Employee employee = new Employee(20, "aravind@gmail.com", "aravind", "88847", "1234", "admin", "management222",
				"12345");

		Mockito.when(employeeRepository.save(Mockito.any())).thenReturn(employee);

		// when - action or the behaviour that we are going test
		ResponseModel employee2 = employeeServiceImpl.addEmployee(employee);

		// then -verify the output assertEquals(employee),
		assertEquals(employee, employee2.getData());

	}

	@Test
	void addEmployeeInvalidTest() throws Exception {
		Employee employee = new Employee(20, "aravind@gmail.com", "aravind", "88847", "1234", "admin", "management",
				"12345");

		Mockito.when(employeeRepository.findByEmail(Mockito.any())).thenReturn(employee);

		// when - action or the behaviour that we are going test
		ResponseModel employee2 = employeeServiceImpl.addEmployee(employee);

		// then -verify the output assertNotEquals(Employee,employee2.getData())
		assertNotEquals(employee, employee2.getData());

	}

	@Test
	void fetchEmployeeByEmailAndPasswordTest() throws Exception {
		Employee employee = new Employee(33, "aravind@gmail.com", "aravind", "88847", "1234", "admin", "management",
				"12345");
		Employee employee1 = new Employee(0, "aravind@gmail.com", "", "", "1234", "", "", "");
		Mockito.when(employeeRepository.findByEmailAndPassword(Mockito.any(), Mockito.any())).thenReturn(employee);
		ResponseModel employee2 = employeeServiceImpl.fetchEmployeeByEmailAndPassword(employee1);

		assertEquals(employee, employee2.getData());
	}

	@Test
	void fetchEmployeeByEmailAndPasswordNullTest() throws Exception {
		Employee employee = new Employee(20, "", "aravind", "88847", "", "admin", "management1111", "12345");
		Employee employee1 = null;
		Mockito.when(employeeRepository.findByEmailAndPassword(Mockito.any(), Mockito.any())).thenReturn(employee1);
		ResponseModel employee2 = employeeServiceImpl.fetchEmployeeByEmailAndPassword(employee);
		assertNull(employee2.getData());
	}
}
