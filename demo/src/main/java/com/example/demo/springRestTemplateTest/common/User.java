package com.example.demo.springRestTemplateTest.common;

public class User {
	private int id;
	private String name;
	private String w3cAccount;
	private String w3cAccountNumber;
	private String remark;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getW3cAccount() {
		return w3cAccount;
	}
	public void setW3cAccount(String w3cAccount) {
		this.w3cAccount = w3cAccount;
	}
	public String getW3cAccountNumber() {
		return w3cAccountNumber;
	}
	public void setW3cAccountNumber(String w3cAccountNumber) {
		this.w3cAccountNumber = w3cAccountNumber;
	}
	public String getRemark() {
		return remark;
	}
	public void setRemark(String remark) {
		this.remark = remark;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", name=" + name + ", w3cAccount=" + w3cAccount + ", w3cAccountNumber="
				+ w3cAccountNumber + ", remark=" + remark + "]";
	}
	public User(int id, String name, String w3cAccount, String w3cAccountNumber, String remark) {
		super();
		this.id = id;
		this.name = name;
		this.w3cAccount = w3cAccount;
		this.w3cAccountNumber = w3cAccountNumber;
		this.remark = remark;
	}
	public User() {
		super();
	}
	
	
	

}
