package com.dbproj.model;

public class Graduate {
	private int userId;
	private String userName;
	private String sex;
	private String birthYear;
	private String grade;
	private int collegeId;
	private String graduateTime;
	
	public int getUserId() { return this.userId; }
	public void setUserId(int userId) { this.userId = userId; }
	
	public String getUserName() { return this.userName; }
	public void setUserName(String userName) { this.userName = userName; }
	
	public String getSex() { return this.sex; }
	public void setSex(String sex) { this.sex = sex; }
	
	public String getBirthYear() { return this.birthYear; }
	public void setBirthYear(String birthYear) { this.birthYear = birthYear; }
	
	public String getGrade() { return this.grade; }
	public void setGrade(String grade) { this.grade = grade; }
	
	public int getCollegeId() { return this.collegeId; }
	public void setCollegeId(int collegeId) { this.collegeId = collegeId; }
	
	public String getGraduateTime() { return this.graduateTime; }
	public void setGraduateTime(String graduateTime) { this.graduateTime = graduateTime; }
}
