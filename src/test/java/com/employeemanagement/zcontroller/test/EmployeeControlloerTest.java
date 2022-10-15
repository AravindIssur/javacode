package com.employeemanagement.zcontroller.test;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import com.employeemanagement.entity.Employee;
import com.employeemanagement.responsemodel.ResponseModel;
import com.employeemanagement.service.EmployeeService;
import com.employeemanagement.zcontroller.EmployeeController;
import com.fasterxml.jackson.databind.ObjectMapper;

@SpringBootTest
@AutoConfigureMockMvc
 class EmployeeControlloerTest {
	
	@MockBean
	private EmployeeService employeeServiceImpl;
	
	@InjectMocks
	private EmployeeController employeeController;
	
	@Autowired
	private MockMvc mockMvc;
	@Autowired
	private ObjectMapper objectMapper;
	

	
	@Test
	void addEmployeeTest() throws Exception {
		Employee employee = new Employee(20, "aravind1234@gmail.com", "aravind", "88847", "1234", "admin", "management222",
				"12345");
		ResponseModel model= new ResponseModel();
		model.setData(employee);
		when(employeeServiceImpl.addEmployee(Mockito.any())).thenReturn(model);
		mockMvc.perform(post("/employee/addemployee").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(employee))).andExpect(status().isCreated()).andDo(print());
	}
	
	@Test
	 void addEmployeeInvalidTest() throws Exception {
		Employee employee = new Employee(20, "aravind1234@gmail.com", "aravind", "88847", "1234", "admin", "management222",
				"12345");
		ResponseModel model= new ResponseModel();
		model.setData(employee);
		when(employeeServiceImpl.addEmployee(employee)).thenReturn(model);
		mockMvc.perform(post("/employee/addemployee").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isBadRequest()).andDo(print());
}
	
	@Test
	 void loginTest() throws Exception {
		Employee employee = new Employee(20, "aravind1234@gmail.com", "aravind", "88847", "1234", "admin", "management222",
				"12345");
		ResponseModel model= new ResponseModel();
		model.setData(employee);
		Mockito.when(employeeServiceImpl.fetchEmployeeByEmailAndPassword(Mockito.any())).thenReturn(model);	
		mockMvc.perform(post("/employee/login").contentType(MediaType.APPLICATION_JSON)
				.content(objectMapper.writeValueAsString(employee))).andExpect(status().isOk()).andDo(print());
		}
	
	@Test
	 void loginInVaalidTest() throws Exception {
		Employee employee = new Employee(20, " ", "aravind", "88847", "", "admin", "management222",
				"12345");
		ResponseModel model= new ResponseModel();
		model.setData(employee);
		Mockito.when(employeeServiceImpl.fetchEmployeeByEmailAndPassword(Mockito.any())).thenReturn(model);	
		mockMvc.perform(post("/employee/login")).andExpect(status().isBadRequest());		
	}
	

}
