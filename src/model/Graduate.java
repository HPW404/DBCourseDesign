package model;

import java.util.Date;

public class Graduate {
	private int userId;
	private String userName;
	private String sex;
	private Date birthYear;
	private Date grade;
	private int collegeId;
	private Date graduateTime;
	
	public Graduate() { super(); }
	
	public Graduate(int userId, String userName, String sex, Date birthYear, Date grade, int collegeId, Date graduateTime) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.sex = sex;
		this.birthYear = birthYear;
		this.grade = grade;
		this.collegeId = collegeId;
		this.graduateTime = graduateTime;
	}
	
	public int getUserId() { return this.userId; }
	public void setUserId(int userId) { this.userId = userId; }
	
	public String getUserName() { return this.userName; }
	public void setUserName(String userName) { this.userName = userName; }
	
	public String getSex() { return this.sex; }
	public void setSex(String sex) { this.sex = sex; }
	
	public Date getBirthYear() { return this.birthYear; }
	public void setBirthYear(Date birthYear) { this.birthYear = birthYear; }
	
	public Date getGrade() { return this.grade; }
	public void setGrade(Date grade) { this.grade = grade; }
	
	public int getCollegeId() { return this.collegeId; }
	public void setCollegeId(int collegeId) { this.collegeId = collegeId; }
	
	public Date getGraduateTime() { return this.graduateTime; }
	public void setGraduateTime(Date graduateTime) { this.graduateTime = graduateTime; }
}
