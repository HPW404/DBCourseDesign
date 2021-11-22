package model;

import java.util.Date;

public class TC {
	private int teacherId;
	private String teacherName;
	private int courseId;
	private String courseName;
	private Date examTime;
	
	public TC() { super(); }
	
	public TC(int teacherId, String teacherName, int courseId, String courseName, Date examTime) {
		super();
		this.teacherId = teacherId;
		this.teacherName = teacherName;
		this.courseId = courseId;
		this.courseName = courseName;
		this.examTime = examTime;
	}
	
	public int getTeacherId() { return this.teacherId; }
	public void setTeacherId(int teacherId) { this.teacherId = teacherId; }
	
	public String getTeacherName() { return this.teacherName; }
	public void setTeacherName(String teacherName) { this.teacherName = teacherName; }
	
	public int getCourseId() { return this.courseId; }
	public void setCourseId(int courseId) { this.courseId = courseId; }
	
	public String getCourseName() { return this.courseName; }
	public void setCourseName(String courseName) { this.courseName = courseName; }
	
	public Date getExamTime() { return this.examTime; }
	public void setExamTime(Date examTime) { this.examTime = examTime; }
}
