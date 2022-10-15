package com.employeemanagement.responsemodel;

public class ResponseModel {
	
	private Object data;
	private Object error;
	private Object authorization;
	
	public Object getData() {
		return data;
	}
	public void setData(Object data) {
		this.data = data;
	}
	public Object getError() {
		return error;
	}
	public void setError(Object error) {
		this.error = error;
	}
	public Object getAuthorization() {
		return authorization;
	}
	public void setAuthorization(Object authorization) {
		this.authorization = authorization;
	}
	

}
