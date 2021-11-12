package model;

public class SelectedCourse {
	private int courseId;
	private int stuId;
	private int mark;
	private String examTime;
	
	public SelectedCourse() { super(); }
	
	public SelectedCourse(int courseId, int stuId, int mark, String examTime) {
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
	
	public String getExamTime() { return this.examTime; }
	public void setExamTime(String examTime) { this.examTime = examTime; }
}
