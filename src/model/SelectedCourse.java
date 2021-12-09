package model;

import java.util.Date;

public class SelectedCourse {
	private int courseId;
	private int stuId;
	private int mark;
	private Date examTime;
	
	public SelectedCourse() { super(); }
	
	public SelectedCourse(int courseId, int stuId) {
		super();
		this.courseId = courseId;
		this.stuId = stuId;
	}
	
	public SelectedCourse(int courseId, int stuId, int mark, Date examTime) {
		super();
		this.courseId = courseId;
		this.stuId = stuId;
		this.mark = mark;
		this.examTime = examTime;
	}
	
	public int getCourseId() { return this.courseId; }
	public void setCourseId(int courseId) { this.courseId = courseId; }
	
	public int getStuId() { return this.stuId; }
	public void setStuId(int stuId) { this.stuId = stuId; }
	
	public int getMark() { return this.mark; }
	public void setMark(int mark) { this.mark = mark; }
	
	public Date getExamTime() { return this.examTime; }
	public void setExamTime(Date examTime) { this.examTime = examTime; }
}
