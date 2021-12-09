package dao.Impl;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;

import model.CourseInfo;
import model.PageBean;
import dao.CourseInfoDao;
import db.DBCon;;

public class CourseInfoDaoImpl implements CourseInfoDao {
	private DBCon conn = new DBCon();
	private CourseInfo courseInfo;
	private PageBean pageBean;
	
	// 添加课程信息
	public int addCourseInfo(CourseInfo courseInfo) {
		String sql = "insert into courseinfo(courseID, courseWeek, courseType, collegeID, score) values("
				+ courseInfo.getCourseId() 
				+ ", "
				+ courseInfo.getCourseWeek() 
				+ ", '"
				+ courseInfo.getCourseType() 
				+ "', "
				+ courseInfo.getCollegeId() 
				+ ", "
				+ courseInfo.getScore() 
				+ ")";
		int rs = conn.query(sql);
		return rs;
	}
	
	// 删除课程信息
	public int deleteCourseInfo(int courseId) {
		String sql = "delete from courseinfo where courseID = " 
				+ courseId;
		int rs = conn.query(sql);
		return rs;
	}
	
	// 编辑课程信息
	public int editCourseInfo(CourseInfo courseInfo) {
		String sql = "update courseinfo set courseWeek = "
				+ courseInfo.getCourseWeek() 
				+ ", courseType = '"
				+ courseInfo.getCourseType() 
				+ "', score = "
				+ courseInfo.getScore()
				+ " where courseID = " 
				+ courseInfo.getCourseId();
		int rs = conn.query(sql);
		return rs;
	}
	
	// 选择课程信息
	public CourseInfo selectCourseInfo(CourseInfo courseInfo) {
		String sql = "select * from courseinfo where courseID = "
				+ courseInfo.getCourseId();
		CourseInfo c = null;
		ResultSet rs = conn.find(sql);
		try {
			while(rs.next()) {
				int courseId = rs.getInt("courseID");
				String courseName = rs.getString("courseName");
				int courseWeek = rs.getInt("courseWeek");
				String courseType = rs.getString("courseType");
				int collegeId = rs.getInt("collegeID");
				int score = rs.getInt("score");
				c = new CourseInfo(courseId, courseName, courseWeek, courseType, collegeId, score);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c;
	}
	
	// 查看所有课程信息
	public List<CourseInfo> findAll() {
		List<CourseInfo> list = new ArrayList<CourseInfo>();
		String sql = "select * from courseinfo";
		ResultSet rs = conn.find(sql);
		try {
			while(rs.next()) {
				int courseId = rs.getInt("courseID");
				String courseName = rs.getString("courseName");
				int courseWeek = rs.getInt("courseWeek");
				String courseType = rs.getString("courseType");
				int collegeId = rs.getInt("collegeID");
				int credit = rs.getInt("score");
				courseInfo = new CourseInfo(courseId, courseName, courseWeek, courseType, collegeId, credit);
				list.add(courseInfo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	// 查看单个课程信息
	public List<CourseInfo> findOne(int courseId) {
		List<CourseInfo> list = new ArrayList<CourseInfo>();
		String sql = "select * from courseinfo where courseID = " + courseId;
		ResultSet rs = conn.find(sql);
		try {
			while(rs.next()) {
				int courseID = rs.getInt("courseID");
				String courseName = rs.getString("courseName");
				int courseWeek = rs.getInt("courseWeek");
				String courseType = rs.getString("courseType");
				int collegeId = rs.getInt("collegeID");
				int credit = rs.getInt("score");
				courseInfo = new CourseInfo(courseID, courseName, courseWeek, courseType, collegeId, credit);
				list.add(courseInfo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	// 分页查询课程信息
	public PageBean courseInfoPageList(int pageNo, int pageCount) {
		List<CourseInfo> list = new ArrayList<CourseInfo>();
		int totalCount = 0;
		String sql = "select * from courseinfo limit " 
				+ ((pageNo - 1) * pageCount) 
				+ ", " 
				+ pageCount;
		String sqlCount = "select count(*) from courseinfo";
		ResultSet rs = conn.find(sql);
		try {
			while(rs.next()) {
				int courseId = rs.getInt("courseID");
				String courseName = rs.getString("courseName");
				int courseWeek = rs.getInt("courseWeek");
				String courseType = rs.getString("courseType");
				int collegeId = rs.getInt("collegeID");
				int credit = rs.getInt("score");
				courseInfo = new CourseInfo(courseId, courseName, courseWeek, courseType, collegeId, credit);
				list.add(courseInfo);
			}
			rs = conn.find(sqlCount);
			while(rs.next()) {
				totalCount = rs.getInt(1);
			}
			pageBean = new PageBean(list, totalCount, pageNo, pageCount);
		} catch (SQLException e) {
			conn.close();
			e.printStackTrace();
		}
		return pageBean;
	}
}
