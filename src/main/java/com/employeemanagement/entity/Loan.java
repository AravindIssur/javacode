package com.employeemanagement.entity;

public class Loan {
	
	private long loanId;
	private String loanName;
	private String loanType;
	private String loanDescription;
	private Float percentage;
	public long getLoanId() {
		return loanId;
	}
	public void setLoanId(long loanId) {
		this.loanId = loanId;
	}
	public String getLoanName() {
		return loanName;
	}
	public void setLoanName(String loanName) {
		this.loanName = loanName;
	}
	public String getLoanType() {
		return loanType;
	}
	public void setLoanType(String loanType) {
		this.loanType = loanType;
	}
	public String getLoanDescription() {
		return loanDescription;
	}
	public void setLoanDescription(String loanDescription) {
		this.loanDescription = loanDescription;
	}
	public Float getPercentage() {
		return percentage;
	}
	public void setPercentage(Float percentage) {
		this.percentage = percentage;
	}
	public Loan() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Loan(long loanId, String loanName, String loanType, String loanDescription, Float percentage) {
		super();
		this.loanId = loanId;
		this.loanName = loanName;
		this.loanType = loanType;
		this.loanDescription = loanDescription;
		this.percentage = percentage;
	}

	
	
	

}
