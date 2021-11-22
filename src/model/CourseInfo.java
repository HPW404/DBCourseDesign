package model;

public class CourseInfo {
	private int courseId;
	private String courseName;
	private int courseWeek;
	private String courseType;
	private int collegeId;
	private int score;				// ังทึ
	
	public CourseInfo() { super(); }

	public CourseInfo(int courseId, String courseName, int courseWeek, String courseType, int collegeId, int score) {
		super();
		this.courseId = courseId;
		this.courseName = courseName;
		this.courseWeek = courseWeek;
		this.courseType = courseType;
		this.collegeId = collegeId;
		this.score = score;
	}
	
	public int getCourseId() { return this.courseId; }
	public void setCourseId(int courseId) { this.courseId = courseId; }
	
	public String getCourseName() { return this.courseName; }
	public void setCourseName(String courseName) { this.courseName = courseName; }
	
	public int getCourseWeek() { return this.courseWeek; }
	public void setCourseWekk(int courseWeek) { this.courseWeek = courseWeek; }
	
	public String getCourseType() { return this.courseType; }
	public void setCourseType(String courseType) { this.courseType = courseType; }
	
	public int getCollegeId() { return this.collegeId; }
	public void setCollegeId(int collegeId) { this.collegeId = collegeId; }
	
	public int getScore() { return this.score; }
	public void setScore(int score) { this.score = score; }
}
