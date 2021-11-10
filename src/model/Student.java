package model;

import java.util.Date;

/*
 * 学生数据结构
 */

public class Student {
	private int stuId;
	private String stuName;
	private String sex;
	private Date birthYear;	// 出生日期
	private Date grade;		// 入学年级
	private int collegeId;		// 学院ID
	
	public Student() { super(); }
	
	public Student(int stuId, String stuName, String sex, Date birthYear, Date grade, int collegeId) {
		super();
		stuId = this.stuId;
		stuName = this.stuName;
		sex = this.sex;
		birthYear = this.birthYear;
		grade = this.birthYear;
		collegeId = this.collegeId;
	}
	
	public int getStuId() { return this.stuId; }
	public void setStuId(int stuId) { this.stuId = stuId; }
	
	public String getStuName() { return this.stuName; }
	public void setStuName(String stuName) { this.stuName = stuName; }
	
	public String getSex() { return this.sex; }
	public void setSex(String sex) { this.sex = sex; }
	
	public Date getBirthYear() { return this.birthYear; }
	public void setBirthYear(Date birthYear) { this.birthYear = birthYear; }
	
	public Date getGrade() { return this.grade; }
	public void setGrade(Date grade) { this.grade = grade; }
	
	public int getCollegeId() { return this.collegeId; }
	public void setCollegeId(int collegeId) { this.collegeId = collegeId; }
}
