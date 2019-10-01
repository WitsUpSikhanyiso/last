package com.packagename.myapp;

public class Course {
//	private String courseCode;
	private int id;
	private String code;
	private String name;
	private int lectureId;
	private int coordinatorId;
	public Course(int courseId, String courseCode, String courseName, int lectureId, int coordinatorId) {
		this.id = courseId;
		this.code = courseCode;
		this.name = courseName;
		this.lectureId = lectureId;
		this.coordinatorId = coordinatorId;
		
	}
	
	public int getId() {
		return this.id;
	}
	
	public String getCode() {
		return this.code;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getCoordinatorId() {
		return this.coordinatorId;
	}
	
	public int getLectureId() {
		return this.lectureId;
	}
	
	public static boolean courseExist( String courseCode ) {
		
//		String sql = "select * from courses";
//		
//		if(  ) {
//			return true;
//		}
//		else {
//			return false;
//		}
//		
		
		return true;
	}

}
