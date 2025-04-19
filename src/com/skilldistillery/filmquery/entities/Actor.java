package com.skilldistillery.filmquery.entities;

public class Actor{
	
	//fields
	private int id;
	private String firstName;
	private String lastName;
	
	//no-arg ctor
	public Actor() {
		
	}
	
	//getters and setters
	public int getId() {
		return id;
	}
	
	
	
	public void setId(int id) {
		this.id = id;
	}
	
	
	
	public String getFirstName() {
		return firstName;
	}
	
	
	
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	
	
	
	public String getLastName() {
		return lastName;
	}
	
	
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	
	//toString
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Actor [id=").append(id).append(", firstName=").append(firstName).append(", lastName=")
		.append(lastName).append("]");
		return builder.toString();
	}
	
	
	
	
}
