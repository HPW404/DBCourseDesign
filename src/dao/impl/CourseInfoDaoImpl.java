package dao.impl;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;

import model.CourseInfo;
import model.PageBean;
import dao.CourseInfoDao;
import util.JdbcUtil;

public class CourseInfoDaoImpl implements CourseInfoDao {
	private JdbcUtil conn = new JdbcUtil();
	private CourseInfo courseInfo;
	private PageBean pageBean;
	
	// ��ӿγ���Ϣ
	public int addCourseInfo(CourseInfo courseInfo) {
		String sql = "insert into courseinfo(courseID, courseWeek, courseType, collegeID, score) values("
				+ courseInfo.getCourseId() + ", "
				+ courseInfo.getCourseWeek() + ", '"
				+ courseInfo.getCourseType() + "', "
				+ courseInfo.getCollegeId() + ", "
				+ courseInfo.getScore() + ")";
		int rs = conn.query(sql);
		return rs;
	}
	
	// ɾ���γ���Ϣ
	public int deleteCourseInfo(int courseId) {
		String sql = "delete from courseinfo where courseID = " + courseId;
		int rs = conn.query(sql);
		return rs;
	}
	
	// �༭�γ���Ϣ
	public int editCourseInfo(CourseInfo courseInfo) {
		String sql = "update courseinfo set courseWeek = "
				+ courseInfo.getCourseWeek() + ", courseType = '"
				+ courseInfo.getCourseType() + "', score = "
				+ courseInfo.getScore()
				+ " where courseID = " + courseInfo.getCourseId();
		int rs = conn.query(sql);
		return rs;
	}
	
	// �鿴���пγ���Ϣ
	public List<CourseInfo> findAll() {
		List<CourseInfo> list = new ArrayList<CourseInfo>();
		String sql = "select * from courseinfo";
		ResultSet rs = conn.find(sql);
		try {
			while(rs.next()) {
				int courseId = rs.getInt("courseID");
				int courseWeek = rs.getInt("courseWeek");
				String courseType = rs.getString("courseType");
				int collegeId = rs.getInt("collegeID");
				int credit = rs.getInt("score");
				courseInfo = new CourseInfo(courseId, courseWeek, courseType, collegeId, credit);
				list.add(courseInfo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	// �鿴�����γ���Ϣ
	public List<CourseInfo> findOne(int courseId) {
		List<CourseInfo> list = new ArrayList<CourseInfo>();
		String sql = "select * from courseinfo where courseID = " + courseId;
		ResultSet rs = conn.find(sql);
		try {
			while(rs.next()) {
				int courseID = rs.getInt("courseID");
				int courseWeek = rs.getInt("courseWeek");
				String courseType = rs.getString("courseType");
				int collegeId = rs.getInt("collegeID");
				int credit = rs.getInt("score");
				courseInfo = new CourseInfo(courseID, courseWeek, courseType, collegeId, credit);
				list.add(courseInfo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	// ��ҳ��ѯ�γ���Ϣ
	public PageBean courseInfoPageList(int pageNo, int pageCount) {
		List<CourseInfo> list = new ArrayList<CourseInfo>();
		int totalCount = 0;
		String sql = "select * from courseinfo limit " + ((pageNo - 1) * pageCount) + ", " + pageCount;
		String sqlCount = "select count(*) from courseinfo";
		ResultSet rs = conn.find(sql);
		try {
			while(rs.next()) {
				int courseId = rs.getInt("courseID");
				int courseWeek = rs.getInt("courseWeek");
				String courseType = rs.getString("courseType");
				int collegeId = rs.getInt("collegeID");
				int credit = rs.getInt("score");
				courseInfo = new CourseInfo(courseId, courseWeek, courseType, collegeId, credit);
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
