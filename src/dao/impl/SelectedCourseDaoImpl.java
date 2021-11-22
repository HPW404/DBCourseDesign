package dao.impl;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;

import model.SelectedCourse;
import model.TC;
import model.PageBean;
import model.SC;
import dao.SelectedCourseDao;
import util.JdbcUtil;

public class SelectedCourseDaoImpl implements SelectedCourseDao {
	private SelectedCourse sCourse = null;
	private SC sc = null;
	private PageBean pageBean = null;
	private JdbcUtil conn = new JdbcUtil();
	
	// 增加选课记录
	public int addSelectedCourse(SelectedCourse sCourse, String examTime) {
		String sql = "insert into selectedcourse(courseID, studentID, mark, examtime) values("
				+ sCourse.getCourseId() 
				+ ", "
				+ sCourse.getStuId() 
				+ ", "
				+ sCourse.getMark() 
				+ ", Date('"
				+ examTime 
				+ "'))";
		int rs = conn.query(sql);
		return rs;
	}
	
	// 删除选课记录
	public int deleteSelectedCourse(int studentId, int courseId) {
		String sql = "delete from selectedcourse where studentID = "
				+ studentId 
				+ " and courseID = "
				+ courseId;
		int rs = conn.query(sql);
		return rs;
	}
	
	// 编辑选课记录（成绩）
	public int editSelectedCourse(SelectedCourse sCourse, String examTime) {
		String sql = "update selectedcourse set mark = "
				+ sCourse.getMark() 
				+ ", examtime = Date('"
				+ examTime 
				+ "') where studentID = "
				+ sCourse.getStuId() 
				+ " and courseID = "
				+ sCourse.getCourseId();
		int rs = conn.query(sql);
		return rs;
	}
	
	// 查询学生所有成绩
	public List<SelectedCourse> findOne(int studentId) {
		List<SelectedCourse> list = new ArrayList<SelectedCourse>();
		String sql = "select * from selectedcourse where studentID = "
				+ studentId;
		ResultSet rs = conn.find(sql);
		try {
			while(rs.next()) {
				int studentID = rs.getInt("studentID");
				int courseId = rs.getInt("courseID");
				int mark = rs.getInt("mark");
				Date examTime = rs.getDate("examtime");
				sCourse = new SelectedCourse(courseId, studentID, mark, examTime);
				list.add(sCourse);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	// 查看单个学生单科成绩
	public List<SC> findStuOne(int studentId, int courseId) {
		List<SC> list = new ArrayList<SC>();
		String sql = "select selectedcourse.studentID, student.userName, selectedcourse.courseID, course.courseName, mark "
				+ "from selectedcourse, student, course "
				+ "where selectedcourse.courseName = course.courseName "
				+ "and selectedcourse.studentID = student.userID "
				+ "and studentID = "
				+ studentId
				+ " and courseID = "
				+ courseId;
		ResultSet rs = conn.find(sql);
		try {
			while(rs.next()) {
				int studentID = rs.getInt("studentId");
				String studentName = rs.getString("studentName");
				int courseID = rs.getInt("courseId");
				String courseName = rs.getString("courseName");
				int mark = rs.getInt("mark");
				sc = new SC(studentID, studentName, courseID, courseName, mark);
				list.add(sc);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	// 查询该学生的该课程是否添加
	public SelectedCourse selectCourseInfo(SelectedCourse sCourse) {
		String sql = "select * from selectedcourse where studentID = "
				+ sCourse.getStuId() 
				+ " and courseID = "
				+ sCourse.getCourseId();
		ResultSet rs = conn.find(sql);
		try {
			while(rs.next()) {
				int studentId = rs.getInt("studentID");
				int courseId = rs.getInt("courseID");
				int mark = rs.getInt("mark");
				Date examTime = rs.getDate("examtime");
				sCourse = new SelectedCourse(courseId, studentId, mark, examTime);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return sCourse;
	}
	
	// 分页查询一个学生成绩信息（使用学号查询）
	public PageBean scPageList(int pageNo, int pageCount, int studentId) {
		int totalCount = 0;
		List<SC> list = new ArrayList<SC>();
		String sql = "select selectedcourse.studentID, student.userName, selectedcourse.courseID, course.courseName, mark "
				+ "from selectedcourse, student, course "
				+ "where selectedcourse.courseID = course.courseID and "
				+ "selectedcourse.studentID = student.userID and "
				+ "studentID = " 
				+ studentId
				+ " limit " 
				+ ((pageNo - 1) * pageCount)
				+ ", " 
				+ pageCount;
		String sqlCount = "select count(*) from selectedcourse, course, student "
				+ "where selectedcourse.courseID = course.courseID and "
				+ "selectedcourse.studentID = student.userID "
				+ "and studentID = " 
				+ studentId 
				+ " limit " 
				+ ((pageNo - 1) * pageCount) 
				+ ", " 
				+ pageCount;
		ResultSet rs = conn.find(sql);
		try {
			while(rs.next()) {
				int studentID = rs.getInt("studentID");
				String stuName = rs.getString("userName");
				int courseID = rs.getInt("courseID");
				String courseName = rs.getString("courseName");
				int mark = rs.getInt("mark");
				sc = new SC(studentID, stuName, courseID, courseName, mark);
				list.add(sc);
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
	
	// 分页查询一个学生成绩信息（使用姓名查询）
	public PageBean scPageList(int pageNo, int pageCount, String studentName) {
		int totalCount = 0;
		List<SC> list = new ArrayList<SC>();
		String sql = "select selectedcourse.studentID, student.userName, selectedcourse.courseID, course.courseName, mark "
				+ "from selectedcourse, student, course "
				+ "where selectedcourse.courseID = course.courseID and "
				+ "selectedcourse.studentID = student.userID and "
				+ "userName = '" 
				+ studentName 
				+ "'"
				+ " limit " 
				+ ((pageNo - 1) * pageCount)
				+ ", " + pageCount;
		String sqlCount = "select count(*) from selectedcourse, course, student "
				+ "where selectedcourse.courseID = course.courseID and "
				+ "selectedcourse.studentID = student.userID "
				+ "and userName = '" 
				+ studentName 
				+ "' "
				+ "limit " 
				+ ((pageNo - 1) * pageCount) 
				+ ", " 
				+ pageCount;
		ResultSet rs = conn.find(sql);
		try {
			while(rs.next()) {
				int studentID = rs.getInt("studentID");
				String stuName = rs.getString("userName");
				int courseID = rs.getInt("courseID");
				String courseName = rs.getString("courseName");
				int mark = rs.getInt("mark");
				sc = new SC(studentID, stuName, courseID, courseName, mark);
				list.add(sc);
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
	
	// 分页显示成绩
	public PageBean scPageList(int pageNo, int pageCount) {
		int totalCount = 0;
		List<SelectedCourse> list = new ArrayList<SelectedCourse>();
		String sql = "select * from selectedcourse limit " 
				+ ((pageNo - 1) * pageCount) 
				+ ", " 
				+ pageCount;
		String sqlCount = "select count(*) from selectedcourse";
		ResultSet rs = conn.find(sql);
		try {
			while(rs.next()) {
				int studentId = rs.getInt("studentID");
				int courseId = rs.getInt("courseID");
				int mark = rs.getInt("mark");
				Date examTime = rs.getDate("examtime");
				sCourse = new SelectedCourse(courseId, studentId, mark, examTime);
				list.add(sCourse);
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
	
	// 显示老师所带课程
	public PageBean teacherCourse(int pageNo, int pageCount, int teacherId, TC tc) {
		int totalCount = 0;
		List<TC> list = new ArrayList<TC>();
		String sql = "select teacher.userID, userName, course.courseID, courseName, examtime "
				+ "from teacher, course, selectedcourse "
				+ "where course.teacherID = teacher.userID "
				+ "and course.courseID = selectedcourse.courseID "
				+ "and course.teacherID = "
				+ teacherId
				+ " limit "
				+ ((pageNo - 1) * pageCount)
				+ ", "
				+ pageCount;
		String sqlCount = "select count(*) "
				+ "from teacher, course, selectedcourse "
				+ "where course.teacherID = teacher.userID "
				+ "and course.courseID = selectedcourse.courseID "
				+ "and course.teacherID = "
				+ teacherId;
		ResultSet rs = conn.find(sql);
		try {
			while(rs.next()) {
				int teacherID = rs.getInt("userID");
				String teacherName = rs.getString("teacherName");
				int courseID = rs.getInt("courseID");
				String courseName = rs.getString("courseName");
				Date examTime = rs.getDate("examtime");
				tc = new TC(teacherID, teacherName, courseID, courseName, examTime);
				list.add(tc);
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
