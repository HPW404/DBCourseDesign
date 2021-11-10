package model;

/*
 * �γ����ݽṹ
 */

public class Course {
	private int courseId;
	private String courseName;
	private int teacherId;
	private String courseTime;	// ����ʱ��
	private String classroom;	// �Ͽν���
	private int status;			// �Ƿ���Ч
	
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
