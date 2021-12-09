package model;

public class CosCInfo {
	private int courseId;
	private String courseName;
	private String teacherName;
	private String courseType;
	private String courseTime;
	private String courseRoom;
	private int courseWeek;
	
	public CosCInfo() { super(); }
	
	public CosCInfo(int courseId, String courseName, String teacherName, String courseType, int courseWeek) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.teacherName = teacherName;
		this.courseType = courseType;
		this.courseWeek = courseWeek;
	}
	public CosCInfo(int courseId, String courseName, String teacherName, String courseType, String courseTime,String courseRoom, int courseWeek) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.teacherName = teacherName;
		this.courseType = courseType;
		this.courseTime=courseTime;
		this.courseRoom=courseRoom;
		this.courseWeek = courseWeek;
	}
	
	public int getCoureId() { return this.courseId; }
	public void setCourseId(int courseId) { this.courseId = courseId; }
	
	public String getCourseName() { return this.courseName; }
	public void setCourseName(String courseName) { this.courseName = courseName; }
	
	public String getTeacherName() { return this.teacherName; }
	public void setTeacherName(String teacherName) { this.teacherName = teacherName; }
	
	public String getCourseType() { return this.courseType; }
	public void setCourseType(String courseType) { this.courseType = courseType; }
	
	public String getCourseTime() { return this.courseTime; }
	public void setCourseTime(String courseTime) { this.courseTime = courseTime; }
	
	public String getCourseRoom() { return this.courseRoom; }
	public void setCourseRoom(String courseRoom) { this.courseRoom = courseRoom; }
	
	public int getCourseWeek() { return this.courseWeek; }
	public void setCourseWeek(int courseWeek) { this.courseWeek = courseWeek; }
}
