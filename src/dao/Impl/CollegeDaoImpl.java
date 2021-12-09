package dao.Impl;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;

import model.College;
import model.PageBean;
import dao.CollegeDao;
import db.DBCon;

public class CollegeDaoImpl implements CollegeDao {
	
	private DBCon conn = new DBCon();
	private College college;
	private PageBean pageBean;
	
	// 添加学院
	public int addCollege(College college) {
		String sql = "insert into college(collegeID, collegeName) values("
				+ college.getCollegeId()
				+ ", '"
				+ college.getCollegeName()
				+ "')";
		int rs = conn.query(sql);
		return rs;
	}
	
	// 删除学院
	public int deleteCollege(int collegeId) {
		String sql = "delete from college where collegeID = " 
				+ collegeId;
		int rs = conn.query(sql);
		return rs;
	}
	
	// 编辑学院
	public int editCollege(College college) {
		String sql = "update college set collegeName = '" 
				+ college.getCollegeName() 
				+ "' where collegeID = "
				+ college.getCollegeId();
		int rs = conn.query(sql);
		return rs;
	}
	
	// 查看所有学员
	public List<College> findAll() {
		List<College> list = new ArrayList<College>();
		String sql = "select * from college";
		ResultSet rs = conn.find(sql);
		try {
			while(rs.next()) {
				int collegeId = rs.getInt("collegeID");
				String collegeName = rs.getString("collegeName");
				college = new College(collegeId, collegeName);
				list.add(college);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	// 选择学院
	public College selectCollege(College college) {
		String sql = "select * from college where collegeID = "
				+ college.getCollegeId() 
				+ " and collegeName = '"
				+ college.getCollegeName() 
				+ "'";
		College c = null;
		ResultSet rs = conn.find(sql);
		try {
			while(rs.next()) {
				int collegeId = rs.getInt("collegeID");
				String collegeName = rs.getString("collegeName");
				c = new College(collegeId, collegeName);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c;
	}
	
	// 查询某个学院
	public List<College> findOne(int collegeId) {
		List<College> list = new ArrayList<College>();
		String sql = "select * from college where collegeID = " 
				+ collegeId;
		ResultSet rs = conn.find(sql);
		try {
			while(rs.next()) {
				int collegeID = rs.getInt("collegeID");
				String collegeName = rs.getString("collegeName");
				college = new College(collegeID, collegeName);
				list.add(college);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	// 分页查询学院
	public PageBean collegePageList(int pageNo, int pageCount) {
		List<College> list = new ArrayList<College>();
		int totalCount = 0;
		String sql = "select * from college limit " 
				+ ((pageNo - 1) * pageCount) 
				+ ", " 
				+ pageCount;
		String sqlCount = "select count(*) from college";
		ResultSet rs = conn.find(sql);
		try {
			while(rs.next()) {
				int collegeID = rs.getInt("collegeID");
				String collegeName = rs.getString("collegeName");
				college = new College(collegeID, collegeName);
				list.add(college);
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
