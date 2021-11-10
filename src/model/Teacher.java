package model;

public class Teacher {
	private int teacherId;
	private String teacherName;
	private String sex;
	private String birthYear;
	private String degree;			// 教师学历
	private String title;			// 教师职称
	private String grade;			// 入职时间
	private int collegeId;			// 学院编号
	
	public Teacher() { }
	
	public int getTeacherId() { return this.teacherId; }
	public void setTeacherId(int teacherId) { this.teacherId = teacherId; }
	
	public String getTeacherName() { return this.teacherName; }
	public void setTeacherName(String teacherName) { this.teacherName = teacherName; }
	
	public String getSex() { return this.sex; }
	public void setSex(String sex) { this.sex = sex; }
	
	public String getBirthYear() { return this.birthYear; }
	public void setBirthYear(String birthYear) { this.birthYear = birthYear; }
	
	public String getDegree() { return this.degree; }
	public void setDegree(String degree) { this.degree = degree; }
	
	public String getTitle() { return this.title; }
	public void setTitle(String title) { this.title = title; }
	
	public String getGrade() { return this.grade; }
	public void setGrade(String grade) { this.grade = grade; }
	
	public int getCollegeId() { return this.collegeId; }
	public void setCollegeId(int collegeId) { this.collegeId = collegeId; }
}
