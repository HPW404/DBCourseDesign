package dao.Impl;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.ArrayList;
import java.util.Date;

import model.Teacher;
import model.PageBean;
import dao.TeacherDao;
import db.DBCon;

public class TeacherDaoImpl implements TeacherDao {
	
	private DBCon conn = new DBCon();
	private Teacher teacher;
	private PageBean pageBean;
	
	// 添加教师
	public int addTeacher(Teacher teacher, String birthYear, String grade) {
		String sql = "insert into teacher(userID, userName, sex, birthYear, degree, title, grade, collegeID) values("
				+ teacher.getTeacherId() 
				+ ", '"
				+ teacher.getTeacherName() 
				+ "', '"
				+ teacher.getSex() 
				+ "', '"
				+ birthYear 
				+ "', '"
				+ teacher.getDegree() 
				+ "', '"
				+ teacher.getTitle() 
				+ "', '"
				+ grade
				+ "', "
				+ teacher.getCollegeId() 
				+ ")";
		int rs = conn.query(sql);
		System.out.println(sql);
		return rs;
	}
	
	// 删除教师
	public int deleteTeacher(int teacherId) {
		String sql = "delete from teacher where userID = " + teacherId;
		int rs = conn.query(sql);
		return rs;
	}
	
	// 编辑教师
	public int editTeacher(Teacher teacher, int teacherId,String teacherName,String sex,Date birthYear,String degree,String title,Date grade,int collegeId) {
		System.out.println(birthYear);
		String sql = "update teacher set userName = '" 
				+ teacherName
				+ "', degree = '" 
				+ degree
				+ "', title = '" 
				+ title
				+"',collegeID='"
				+collegeId
				+ "' where userID="
				+teacher.getTeacherId();
		int rs = conn.query(sql);
		System.out.println(sql);
		return rs;
	}
	
	// 查看所有教师
	public List<Teacher> findAll() {
		List<Teacher> list = new ArrayList<Teacher>();
		String sql = "select * from teacher";
		ResultSet rs = conn.find(sql);
		try {
			while(rs.next()) {
				int teacherId = rs.getInt("userID");
				String teacherName = rs.getString("userName");
				String sex = rs.getString("sex");
				Date birthYear = rs.getDate("birthYear");
				String degree = rs.getString("degree");
				String title = rs.getString("title");
				Date grade = rs.getDate("grade");
				int collegeId = rs.getInt("collegeID");
				teacher = new Teacher(teacherId, teacherName, sex, birthYear, degree, title, grade, collegeId);
				list.add(teacher);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	// 查询某位教师
	public List<Teacher> findOne(int teacherId) {
		List<Teacher> list = new ArrayList<Teacher>();
		String sql = "select * from teacher where userID = " + "'"+teacherId+"'";
		ResultSet rs = conn.find(sql);
		try {
			while(rs.next()) {
				int teacherID = rs.getInt("userID");
				String teacherName = rs.getString("userName");
				String sex = rs.getString("sex");
				Date birthYear = rs.getDate("birthYear");
				String degree = rs.getString("degree");
				String title = rs.getString("title");
				Date grade = rs.getDate("grade");
				int collegeId = rs.getInt("collegeID");
				teacher = new Teacher(teacherID, teacherName, sex, birthYear, degree, title, grade, collegeId);
				list.add(teacher);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	// 分页查询教师
	public PageBean teacherPageList(int pageNo, int pageCount) {
		List<Teacher> list = new ArrayList<Teacher>();
		int totalCount = 0;
		String sql = "select * from teacher limit " 
				+ ((pageNo - 1) * pageCount) 
				+ "," 
				+ pageCount;
		String sqlCount = "select count(*) from teacher";
		ResultSet rs = conn.find(sql);
		try {
			while(rs.next()) {
				int teacherID = rs.getInt("userID");
				String teacherName = rs.getString("userName");
				String sex = rs.getString("sex");
				Date birthYear = rs.getDate("birthYear");
				String degree = rs.getString("degree");
				String title = rs.getString("title");
				Date grade = rs.getDate("grade");
				int collegeId = rs.getInt("collegeID");
				teacher = new Teacher(teacherID, teacherName, sex, birthYear, degree, title, grade, collegeId);
				list.add(teacher);
			}
			rs = conn.find(sqlCount);
			while(rs.next()){
				totalCount = rs.getInt(1);
			}
		} catch (SQLException e) {
			conn.close();
			e.printStackTrace();
		}
		pageBean=new PageBean(list, totalCount, pageNo, pageCount);
		return pageBean;
	}
}
