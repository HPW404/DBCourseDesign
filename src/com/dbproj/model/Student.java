package com.dbproj.model;

/*
 * ѧ�����ݽṹ
 */

public class Student {
	private int stuId;
	private String stuName;
	private String sex;
	private String birthYear;	// ��������
	private String grade;		// ��ѧ�꼶
	private int collegeId;		// ѧԺID
	
	public Student() { }
	
	public int getStuId() { return this.stuId; }
	public void setStuId(int stuId) { this.stuId = stuId; }
	
	public String getStuName() { return this.stuName; }
	public void setStuName(String stuName) { this.stuName = stuName; }
	
	public String getSex() { return this.sex; }
	public void setSex(String sex) { this.sex = sex; }
	
	public String getBirthYear() { return this.birthYear; }
	public void setBirthYear(String birthYear) { this.birthYear = birthYear; }
	
	public String getGrade() { return this.grade; }
	public void setGrade(String grade) { this.grade = grade; }
	
	public int getCollegeId() { return this.collegeId; }
	public void setCollegeId(int collegeId) { this.collegeId = collegeId; }
}
