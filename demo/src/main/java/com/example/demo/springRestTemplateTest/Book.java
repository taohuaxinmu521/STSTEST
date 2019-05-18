package com.example.demo.springRestTemplateTest;

public class Book {
	
	private int id;
	private String name;
	private String length;
	
	public Book() {
	}
	
	
	public Book(int id, String name, String length) {
		super();
		this.id = id;
		this.name = name;
		this.length = length;
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
	public String getLength() {
		return length;
	}
	public void setLength(String length) {
		this.length = length;
	}
	
	@Override
	public String toString() {
		return "Book [id=" + id + ", name=" + name + ", length=" + length + ", getId()=" + getId() + ", getName()="
				+ getName() + ", getLength()=" + getLength() + ", getClass()=" + getClass() + ", hashCode()="
				+ hashCode() + ", toString()=" + super.toString() + "]";
	}
	

}
