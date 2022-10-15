package com.employeemanagement.zcontroller;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.employeemanagement.entity.Employee;
import com.employeemanagement.responsemodel.ResponseModel;
import com.employeemanagement.service.EmployeeService;

/**
 * @author Aravinda D M
 *
 */

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/employee")
public class EmployeeController {

	@Autowired
	private EmployeeService employeeservice;

	/**
	 * Register new Employee
	 * 
	 * @RequestBody employee
	 * @return ResponseModel
	 */
	@PostMapping
	public ResponseEntity<ResponseModel> addEmployee(@RequestBody Employee employee) {
		ResponseModel model = new ResponseModel();
		if (employee != null) {

			model = employeeservice.addEmployee(employee);

		}
		if (model.getError() == null) {

			return new ResponseEntity<>(model, HttpStatus.CREATED);
		} else {
			return new ResponseEntity<>(model, HttpStatus.BAD_REQUEST);
		}
	}

	/**
	 * Check Employee Availble or Not
	 * 
	 * @RequestBody employee
	 * 
	 * @return ResponseModel
	 */

	@PostMapping("/login")
	public ResponseEntity<ResponseModel> login(@RequestBody Employee employee) {
		ResponseModel model = new ResponseModel();
		if (employee != null) {

			model = employeeservice.fetchEmployeeByEmailAndPassword(employee);
		}

		if (model.getError() == null) {
			return new ResponseEntity<>(model, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(model, HttpStatus.BAD_REQUEST);
		}

	}

	/**
	 * GetAll Registered employee from Employee table
	 * 
	 * @return ResponseModel
	 */
	@GetMapping
	public ResponseEntity<ResponseModel> getAllEmployee() {
		ResponseModel model = new ResponseModel();
		model = employeeservice.getAllEmployee();
		if (model.getError() == null) {
			return new ResponseEntity<>(model, HttpStatus.OK);

		} else {
			return new ResponseEntity<>(model, HttpStatus.BAD_REQUEST);

		}
	}

}
