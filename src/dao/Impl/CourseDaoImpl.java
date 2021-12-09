package dao.Impl;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;

import model.Course;
import model.PageBean;
import dao.CourseDao;
import db.DBCon;;


public class CourseDaoImpl implements CourseDao {
	private DBCon conn = new DBCon();
	private Course course;
	private PageBean pageBean;
	
	// 添加课程
	public int addCourse(Course course) {
		String sql = "insert into course(courseId, courseName, teacherId, courseTime, classRoom, SON) values ("
				+ course.getCourseId() 
				+ ", '"
				+ course.getCourseName() 
				+ "', "
				+ course.getTeacherId() 
				+ ", '"
				+ course.getCourseTime() 
				+ "', '"
				+ course.getClassroom() 
				+ "', "
				+ course.getStatus() 
				+ ")";
		int rs = conn.query(sql);
		return rs;
	}
	
	// 删除课程
	public int deleteCourse(int courseId) {
		String sql = "delete from course where courseID = " 
				+ courseId;
		int rs = conn.query(sql);
		return rs;
	}
	
	// 编辑课程
	public int editCourse(Course course) {
		String sql = "update course set courseName = '" 
				+ course.getCourseName()
				+ "', teacherID = " 
				+ course.getTeacherId()
				+ ", courseTime = '" 
				+ course.getCourseTime()
				+ "', classRoom = '" 
				+ course.getClassroom()
				+ "' where courseID = " 
				+ course.getCourseId();
		int rs = conn.query(sql);
		return rs;
	}
	
	// 改变课程状态
	public int banCourse(int courseId, int status) {
		String sql = "update course set SON = " 
				+ status 
				+ " where courseID = " 
				+ courseId;
		int rs = conn.query(sql);
		return rs;
	}
	
	// 查看所有课程
	public List<Course> findAll() {
		List<Course> list = new ArrayList<Course>();
		String sql = "select * from course";
		ResultSet rs = conn.find(sql);
		try {
			while (rs.next()) {
				int courseID = rs.getInt("courseID");
				String courseName = rs.getString("courseName");
				int teacherID = rs.getInt("teacherID");
				String courseTime = rs.getString("courseTime");
				String classroom = rs.getString("classRoom");
				int status = rs.getInt("SON");
				course = new Course(courseID, courseName, teacherID, courseTime, classroom, status);
				list.add(course);
			}

		} catch (SQLException e) {

			e.printStackTrace();
		}
		return list;
	}
		
	// 查看一个课程
	public List<Course> findOne(int courseId) {
		List<Course> list = new ArrayList<Course>();
		String sql = "select * from course where courseID = " + courseId;
		ResultSet rs = conn.find(sql);
		try {
			while (rs.next()) {
				int courseID = rs.getInt("courseID");
				String courseName = rs.getString("courseName");
				int teacherID = rs.getInt("teacherID");
				String courseTime = rs.getString("courseTime");
				String classroom = rs.getString("classRoom");
				int status = rs.getInt("SON");
				course = new Course(courseID, courseName, teacherID, courseTime, classroom, status);
				list.add(course);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	// 选择一门课程
	public Course selectCourse(Course course) {
		String sql = "select * from course where courseName = '"
				+ course.getCourseName() 
				+ "' and teacherID = "
				+ course.getTeacherId();
		Course c = null;
		ResultSet rs = conn.find(sql);
		try {
			while(rs.next()) {
				int courseId = rs.getInt("couseID");
				String courseName = rs.getString("courseName");
				int teacherId = rs.getInt("teacherID");
				String courseTime = rs.getString("courseTime");
				String classroom = rs.getString("classRoom");
				int status = rs.getInt("SON");
				c = new Course(courseId, courseName, teacherId, courseTime, classroom, status);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return c;
	}
	
	// 分页查询课程
	public PageBean coursePageList(int pageNo, int pageCount) {
		int totalCount = 0;
		List<Course> list = new ArrayList<Course>();
		String sql = "select * from course limit " 
				+ ((pageNo-1) * pageCount) 
				+ "," 
				+ pageCount;
		String sqlCount = "select count(*) from course";
		ResultSet rs = conn.find(sql);
		try {
			while (rs.next()) {
				int courseID = rs.getInt("courseID");
				String courseName = rs.getString("courseName");
				int teacherID = rs.getInt("teacherID");
				String courseTime = rs.getString("courseTime");
				String classroom = rs.getString("classRoom");
				int status = rs.getInt("SON");
				course = new Course(courseID, courseName, teacherID, courseTime, classroom, status);
				list.add(course);
			}
			rs = conn.find(sqlCount);
			while(rs.next()){
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
