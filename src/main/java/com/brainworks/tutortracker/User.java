package com.brainworks.tutortracker;

public class User {
	
	private String name;
	private String surname;
	private String email;
	private String password;
	private String studentNumber;
	
	
	User() {
		
	}
	
	public String getName( ) {
		return this.name;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public String getStudentNumber() {
		return this.studentNumber;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public String getSurname() {
		return this.surname;
	}
	
	public void setName(String name )  {
		this.name = name;
	}
	
	public void setSurname(String surname )  {
		this.surname = surname;
	}
	
	public void setEmail( String email ) {
		this.email = email;
	}
	
	public void setPassword( String password ) {
		this.password = password;
	}
	
	public void setStudentNumber( String studentNumber ) {
		this.studentNumber = studentNumber;
	}
	
	public String toString() {
		String line = "";
		line += String.format( "name : [%s]\n", this.name	 );
		line += String.format( "surname : [%s]\n", this.surname );
		line += String.format( "student number : [%s]\n", this.studentNumber);
		line += String.format( "password : [%s]\n", this.password );
		return line;
	}
	

}