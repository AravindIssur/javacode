package com.employeemanagement.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.employeemanagement.entity.Employee;
import com.employeemanagement.repository.EmployeeRepository;
import com.employeemanagement.responsemodel.ResponseModel;
import com.employeemanagement.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired 
	private EmployeeRepository employeeRepository;
	
	public ResponseModel addEmployee(Employee employee) {
		ResponseModel model=new ResponseModel();
		Employee emp= employeeRepository.findByEmail(employee.getEmail());
		if(emp==null) {
			model.setData(employeeRepository.save(employee));
		}
		else {
			model.setError("employee already registered ");
		}
		return model;
	}
	
	@Override
	public ResponseModel fetchEmployeeByEmailAndPassword(Employee employee) {
		ResponseModel model= new ResponseModel();
		Employee emp = employeeRepository.findByEmailAndPassword(employee.getEmail(), employee.getPassword());
		
		if ( emp != null ) {
			model.setData(emp);
		}else {
			model.setError("employee dose not exist");
		}
		
		return model;
	}
	
	@Override
	public ResponseModel getAllEmployee() {
		ResponseModel model= new ResponseModel();
		List<Employee> emp= employeeRepository.findAll();
		model.setData(emp);
		return model;
	}
	

	@Override
	public ResponseModel deleteEmployeeById(String eid) {
		return null;
	}

	@Override
	public ResponseModel updateEmoployee(String id) {
		return null;
	}

}
