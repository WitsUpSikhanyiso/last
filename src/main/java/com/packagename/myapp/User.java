package com.packagename.myapp;



public class User {
	
	
	private String id;
	private String userId;
	private String name;
	private String surname;
	private String email;
	private String password;
	private String hash_password;
	private String type;
	private String phoneNum;
	
	User() {
		
	}
	
	User( String name, String surname, String email, String password, String userId, String type ){
		this.name = name;
		this.surname = surname;
		this.email = email;
		this.password = password;
		this.userId = userId;
		this.type = type;
	}
	/*
	 * get and set methods
	 * 
	 */
	public String getPhoneNum(){
		return this.phoneNum;
	}
	
	public void setPhoneNum( String phonenum ){
		this.phoneNum = phonenum;
	}
	
	public String getType() {
		return this.type;
	}
	
	public String getName( ) {
		return this.name;
	}
	
	public String getEmail() {
		return this.email;
	}
	
	public String getHashPassword(){
		return this.hash_password;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public String getSurname() {
		return this.surname;
	}
	
	public void setType( String type ) {
		this.type = type;
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
	
	public void setId(String id){
		this.id = id;
	}
	
	public void setUserId( String userId ){
		this.userId = userId;
	}
	
	public String getId(){
		return this.id;
	}
	
	public String getUserId(){
		return this.userId;
	}
	
	public void setPassword( String password ) {
		this.password = password;
	}
	
	
	public void setHashPassword( String hash_password ){
		this.hash_password = hash_password;
	}
	

	
	public String toString() {
		String line = "";
		line += String.format( "id: [%s]\n", this.id);
		line += String.format( "userId: [%s]\n", this.userId);
		line += String.format( "name : [%s]\n", this.name	 );
		line += String.format( "surname : [%s]\n", this.surname );
		line += String.format( "phone_number : [%s]\n", this.phoneNum);
		line += String.format( "email : [%s]\n", this.email);
		line += String.format( "password : [%s]\n", this.password );
		line += String.format( "type : [%s]\n", this.type);
		return line;
	}
	

}
