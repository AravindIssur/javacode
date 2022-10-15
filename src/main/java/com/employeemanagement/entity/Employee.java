package com.employeemanagement.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Employee")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "EID")
	private int eid;
	@Column(name = "Email")
	private String email;
	@Column(name = "Ename")
	private String ename;
	@Column(name = "Mobile")
	private String mobile;
	@Column(name = "Password")
	private String password;
	@Column(name = "Role")
	private String role;
	@Column(name = "Dept")
	private String dept;
	@Column(name = "Salary")
	private String salary;
    
	
	
	public Employee() {
		super();
	}
	
	
	

	public Employee(int eid, String email, String ename, String mobile, String password, String role, String dept,
			String salary) {
		super();
		this.eid = eid;
		this.email = email;
		this.ename = ename;
		this.mobile = mobile;
		this.password = password;
		this.role = role;
		this.dept = dept;
		this.salary = salary;
	}




	public int getEid() {
		return eid;
	}

	public void setEid(int eid) {
		this.eid = eid;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getEname() {
		return ename;
	}

	public void setEname(String ename) {
		this.ename = ename;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public String getDept() {
		return dept;
	}

	public void setDept(String dept) {
		this.dept = dept;
	}

	public String getSalary() {
		return salary;
	}

	public void setSalary(String salary) {
		this.salary = salary;
	}


}
