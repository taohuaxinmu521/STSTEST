package com.example.demo.springRestTemplateTest.common;

public class PersonRehiredVo {
	
	private int id;
	private String name;
	private String oldW3account;
	private String newW3account;
	private String oldNumber;
	private String newNumber;
	private String lastName;
	
	public PersonRehiredVo() {
		super();
	}

	public PersonRehiredVo(int id, String name, String oldW3account, String newW3account, String oldNumber,
			String newNumber, String lastName) {
		super();
		this.id = id;
		this.name = name;
		this.oldW3account = oldW3account;
		this.newW3account = newW3account;
		this.oldNumber = oldNumber;
		this.newNumber = newNumber;
		this.lastName = lastName;
	}
	
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
	public String getOldW3account() {
		return oldW3account;
	}
	public void setOldW3account(String oldW3account) {
		this.oldW3account = oldW3account;
	}
	public String getNewW3account() {
		return newW3account;
	}
	public void setNewW3account(String newW3account) {
		this.newW3account = newW3account;
	}
	public String getOldNumber() {
		return oldNumber;
	}
	public void setOldNumber(String oldNumber) {
		this.oldNumber = oldNumber;
	}
	public String getNewNumber() {
		return newNumber;
	}
	public void setNewNumber(String newNumber) {
		this.newNumber = newNumber;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	@Override
	public String toString() {
		return "PersonRehiredVo [id=" + id + ", name=" + name + ", oldW3account=" + oldW3account + ", newW3account="
				+ newW3account + ", oldNumber=" + oldNumber + ", newNumber=" + newNumber + ", lastName=" + lastName
				+ "]";
	}
	
	
	
	

}
