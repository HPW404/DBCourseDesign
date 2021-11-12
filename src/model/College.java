package model;

/*
 * 学院数据结构
 */

public class College {
	private int collegeId;
	private String collegeName;
	
	public College() { super(); }
	
	public College(int collegeId, String collegeName) {
		super();
		this.collegeId = collegeId;
		this.collegeName = collegeName;
	}
	
	public int getCollegeId() { return this.collegeId; }
	public void setCollegeId(int collegeId) { this.collegeId = collegeId; }
	
	public String getCollegeName() { return this.collegeName; }
	public void setCollegeName(String collegeName) { this.collegeName = collegeName; }
}
