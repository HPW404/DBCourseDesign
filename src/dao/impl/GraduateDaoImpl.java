package dao.impl;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;

import model.Graduate;
import model.PageBean;
import dao.GraduateDao;
import util.JdbcUtil;

public class GraduateDaoImpl implements GraduateDao {
	private JdbcUtil conn = new JdbcUtil();
	private Graduate graduate;
	private PageBean pageBean;
	
	// 添加毕业生
	public int addGraduate(Graduate graduate, String birthYear, String grade, String graduateTime) {
		String sql = "insert into graduate(userID, userName, sex, birthYear, grade, collegeID, graduateTime) values("
				+ graduate.getUserId() + ", '"
				+ graduate.getUserName() + "', '"
				+ graduate.getSex() + "', Date('"
				+ birthYear + "'), Date('"
				+ grade + "'), "
				+ graduate.getCollegeId() + ", Date('"
				+ graduateTime + "'))";
		int rs = conn.query(sql);
		return rs;
	}
	
	// 编辑毕业生
	public int editGraduate(Graduate graduate, String birthYear, String grade, String graduateTime) {
		String sql = "update graduate set userName = " + graduate.getUserName()
				+ ", birthYear = " + birthYear
				+ ", grade = " + grade
				+ ", graduateTime = " + graduateTime;
		int rs = conn.query(sql);
		return rs;
	}
	
	// 删除毕业生
	public int deleteGraduate(int userId) {
		String sql = "delete from graduate where userID = " + userId;
		int rs = conn.query(sql);
		return rs;
	}
	
	// 查看全部毕业生
	public List<Graduate> findAll() {
		List<Graduate> list = new ArrayList<Graduate>();
		String sql = "select * from graduate";
		ResultSet rs = conn.find(sql);
		try {
			while(rs.next()) {
				int userId = rs.getInt("userID");
				String userName = rs.getString("userName");
				String sex = rs.getString("sex");
				Date birthYear = rs.getDate("birthYear");
				Date grade = rs.getDate("grade");
				int collegeId = rs.getInt("collegeID");
				Date graduateTime = rs.getDate("graduateTime");
				graduate = new Graduate(userId, userName, sex, birthYear, grade, collegeId, graduateTime);
				list.add(graduate);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	// 查询单个毕业生
	public List<Graduate> findOne(int userId) {
		List<Graduate> list = new ArrayList<Graduate>();
		String sql = "select * from graduate where userID = " + userId;
		ResultSet rs = conn.find(sql);
		try {
			while(rs.next()) {
				int userID = rs.getInt("userID");
				String userName = rs.getString("userName");
				String sex = rs.getString("sex");
				Date birthYear = rs.getDate("birthYear");
				Date grade = rs.getDate("grade");
				int collegeId = rs.getInt("collegeID");
				Date graduateTime = rs.getDate("graduateTime");
				graduate = new Graduate(userID, userName, sex, birthYear, grade, collegeId, graduateTime);
				list.add(graduate);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public PageBean graduatePageList(int pageNo, int pageCount) {
		List<Graduate> list = new ArrayList<Graduate>();
		int totalCount = 0;
		String sql = "select * from graduate limit " + ((pageNo - 1) * pageCount) + ", " + pageCount;
		String sqlCount = "select count(*) from guaduate";
		ResultSet rs = conn.find(sql);
		try {
			while(rs.next()) {
				int userId = rs.getInt("userID");
				String userName = rs.getString("userName");
				String sex = rs.getString("sex");
				Date birthYear = rs.getDate("birthYear");
				Date grade = rs.getDate("grade");
				int collegeId = rs.getInt("collegeID");
				Date graduateTime = rs.getDate("graduateTime");
				graduate = new Graduate(userId, userName, sex, birthYear, grade, collegeId, graduateTime);
				list.add(graduate);
			}
			rs = conn.find(sqlCount);
			while(rs.next()) {
				totalCount = rs.getInt(1);
			}
			pageBean = new PageBean(list, totalCount, pageNo, pageCount);
		} catch (Exception e) {
			conn.close();
			e.printStackTrace();
		}
		return pageBean;
	}
}
