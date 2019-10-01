package com.packagename.myapp;

public class Session {
	private int id;
	private String courseCode;
	private String date;
	private String start_time;
	private String end_time;
	private String venue;
	private String notes;
	
	
	
	
	public Session( int id, String courseCode, String date, String start_time, String end_time, String venue, String notes ){
		this.id = id;
		this.courseCode = courseCode;
		this.date = date;
		this.start_time = start_time;
		this.end_time = end_time;
		this.venue = venue;
		this.notes = notes;
	}
	
	public int getId(){
		return this.id;
	}
	
	public String getCourseCode(){
		return this.courseCode;
	}
	
	public String getDate(){
		return this.date;
	}
	
	public String getStartTime(){
		return this.start_time;
	}
	
	public String getEndTime(){
		return this.end_time;
	}
	public String getVenue(){
		return this.venue;
	}
	
	public String getNotes(){
		return this.notes;
	}
	
}
