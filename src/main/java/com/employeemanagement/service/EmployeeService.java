package com.employeemanagement.service;

import com.employeemanagement.entity.Employee;
import com.employeemanagement.responsemodel.ResponseModel;

public interface EmployeeService {
	
	public ResponseModel addEmployee(Employee employee);
	public ResponseModel deleteEmployeeById(String eid);
	public ResponseModel updateEmoployee(String id);
	public ResponseModel getAllEmployee();
	public ResponseModel fetchEmployeeByEmailAndPassword(Employee employee);

}
