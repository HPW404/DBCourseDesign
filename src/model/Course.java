package model;

/*
 * 课程数据结构
 */

public class Course {
	private int courseId;
	private String courseName;
	private int teacherId;
	private String courseTime;	// 开课时间
	private String classroom;	// 上课教室
	private int status;			// 是否有效
	
	public Course() { super(); }
	public Course(int courseId, String courseName, int teacherId, String courseTime, String classroom, int status) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.teacherId = teacherId;
		this.courseTime = courseTime;
		this.classroom = classroom;
		this.status = status;
	}
	
	public int getCourseId() { return this.courseId; }
	public void setCourseId(int courseId) { this.courseId = courseId; }
	
	public String getCourseName() { return this.courseName; }
	public void setCourseName(String courseName) { this.courseName = courseName; }
	
	public int getTeacherId() { return this.teacherId; }
	public void setTeacherId(int teacherId) { this.teacherId = teacherId; }
	
	public String getCourseTime() { return this.courseTime; }
	public void setCourseTime(String courseTime) { this.courseTime = courseTime; }
	
	public String getClassroom() { return this.classroom; }
	public void setClassroom(String classroom) { this.classroom = classroom; }
	
	public int getStatus() { return this.status; }
	public void setStatus(int status) { this.status = status; }
}
