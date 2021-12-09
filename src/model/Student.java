package model;

import java.util.Date;

/*
 * 学生数据结构
 */

public class Student {
	private String stuId;
	private String stuName;
	private String sex;
	private Date birthYear;	// 出生日期
	private Date grade;		// 入学年级
	private int collegeId;		// 学院ID
	
	public Student() { super(); }
	
	public Student( String stuName, String sex, Date birthYear, Date grade, int collegeId) {
		super();
		stuName = this.stuName;
		sex = this.sex;
		birthYear = this.birthYear;
		grade = this.birthYear;
		collegeId = this.collegeId;
	}
	
	public Student(String stuId, String stuName, String sex, Date birthYear, Date grade, int collegeId) {
		super();
		 this.stuId=stuId;
		this.stuName=stuName;
		this.sex=sex;
		this.birthYear=birthYear;
		 this.grade=grade;
		 this.collegeId=collegeId;
	}
	
	public String getStuId() { return this.stuId; }
	public void setStuId(String stuId) { this.stuId = stuId; }
	
	public String getStuName() { return this.stuName; }
	public void setStuName(String stuName) { this.stuName = stuName; }
	
	public String getSex() { return this.sex; }
	public void setSex(String sex) { this.sex = sex; }
	
	public Date getBirthYear() { return this.birthYear; }
	public void setBirthYear(Date birthYear) { this.birthYear = birthYear; }
	
	public Date getGrade() { return grade; }
	public void setGrade(Date grade) { this.grade = grade; }
	
	public int getCollegeId() { return this.collegeId; }
	public void setCollegeId(int collegeId) { this.collegeId = collegeId; }
}
