package com.example.demo.model;

public class Girl {
	
	private String id;
	
	private String age;
	
	private String cupSize;
	
	private String name;
	
	

	public String getId() {
		return id;
	}



	public void setId(String id) {
		this.id = id;
	}



	public String getAge() {
		return age;
	}



	public void setAge(String age) {
		this.age = age;
	}



	public String getCupSize() {
		return cupSize;
	}



	public void setCupSize(String cupSize) {
		this.cupSize = cupSize;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	@Override
	public String toString() {
		return "Girl [id=" + id + ", age=" + age + ", cupSize=" + cupSize + ", name=" + name + "]";
	}
	

}
