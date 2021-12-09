package model;

public class SC {
	private int studentId;
	private String studentName;
	private int courseId;
	private String courseName;
	private int mark;
	
	public SC() { super(); }
	
	public SC(int studentId, String studentName, int courseId, String courseName, int mark) {
		super();
		this.studentId = studentId;
		this.studentName = studentName;
		this.courseId = courseId;
		this.courseName = courseName;
		this.mark = mark;
	}
	
	public SC(int studentId, String courseName, String studentName) {
		super();
		this.courseName = courseName;
		this.studentId = studentId;
		this.studentName = studentName;
	}
	
	public int getStudentId() { return this.studentId; }
	public void setStudentId(int studentId) { this.studentId = studentId; }
	
	public String getStudentName() { return this.studentName; }
	public void setStudentName(String studentName) { this.studentName = studentName; }
	
	public int getCourseId() { return this.courseId; }
	public void setCourseId(int courseId) { this.courseId = courseId; }
	
	public String getCourseName() { return this.courseName; }
	public void setCourseName(String courseName) { this.courseName = courseName; }
	
	public int getMark() { return this.mark; }
	public void setMark(int mark) { this.mark = mark; }
}
