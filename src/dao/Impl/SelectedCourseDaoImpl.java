package dao.Impl;

import java.sql.*;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.ArrayList;

import model.SelectedCourse;
import model.TC;
import model.CosCInfo;
import model.PageBean;
import model.SC;
import dao.SelectedCourseDao;
import db.DBCon;

public class SelectedCourseDaoImpl implements SelectedCourseDao {
	private SelectedCourse sCourse = null;
	private SC sc = null;
	private TC tc = null;
	private CosCInfo cInfo = null;
	private PageBean pageBean = null;
	private DBCon conn = new DBCon();
	
	// 增加选课记录
	public int addSelectedCourse(SelectedCourse sCourse) {
		String sql = "insert into selectedcourse(courseID, studentID) values("
				+ sCourse.getCourseId() 
				+ ", "
				+ sCourse.getStuId()
				+ ")";
		int rs = conn.query(sql);
		return rs;
	}
	
	// 增加成绩记录
	public int addScore(SelectedCourse selectedCourse) {
		
		SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String examtime = simpleDateFormat.format(selectedCourse.getExamTime());
		
		String sql = "insert into selectedcourse(courseID, studentID, mark, examtime) values("
				+ selectedCourse.getCourseId() 
				+ ", "
				+ selectedCourse.getStuId() 
				+ ", "
				+ selectedCourse.getMark() 
				+ ", Date('"
				+ examtime 
				+ "'))";
		int rs = conn.query(sql);
		return rs;
	}
	
	// 添加成绩记录
	public int addScore(SC sc) {
		String sql = "update selectedcourse set mark = "
				+ sc.getMark()
				+ " where studentID = "
				+ sc.getStudentId()
				+ " and courseID = "
				+ sc.getCourseId();
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
	
	// 编辑考试时间
	public int editExamTime(String courseName, String examTime) {
		String sql = "update selectedcourse set examtime = Date('"
				+ examTime
				+ "') where course.courseID = selectedcourse.courseID "
				+ "and course.courseName = '"
				+ courseName
				+ "'";
		int rs = conn.query(sql);
		return rs;
	}
	
	// 选择选课记录
	public CosCInfo selectSelectedCourse(CosCInfo cosCInfo) {
		String sql = "select course.courseID, courseName, teacher.userName, courseType, courseWeek, courseTime, classRoom "
				+ "from course, courseinfo, teacher, selectedcourse "
				+ "where course.courseID = courseinfo.courseID and "
				+ "course.teacherID = teacher.userID and "
				+ "course.courseID = selectedcourse.courseID and "
				+ "course.courseID = "
				+ cosCInfo.getCoureId();
		ResultSet rs = conn.find(sql);
		try {
			while(rs.next()) {
				int courseId = rs.getInt("courseID");
				String courseName = rs.getString("courseName");
				String teacherName = rs.getString("userName");
				String courseType = rs.getString("courseType");
				String courseTime = rs.getString("courseTime");
				String courseRoom = rs.getString("classRoom");
				int courseWeek = rs.getInt("courseWeek");
				System.out.println(courseId);
				cInfo = new CosCInfo(courseId, courseName, teacherName, courseType, courseTime, courseRoom, courseWeek);
				System.out.println(cInfo.getCoureId());
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return cInfo;
	}
	
	// 选择成绩记录
	public SelectedCourse selectSelectedCourse(SelectedCourse selectedCourse) {
		String sql = "select * from selectedcourse "
				+ "where courseID = "
				+ selectedCourse.getCourseId()
				+ " and studentID = "
				+ selectedCourse.getStuId();
		System.out.println(sql);
		ResultSet rs = conn.find(sql);
		SelectedCourse sCourse = null;
		try {
			while(rs.next()) {
				int courseId = rs.getInt("courseID");
				int studentId = rs.getInt("studentID");
				int mark = rs.getInt("mark");
				Date examTime = rs.getDate("examtime");
				sCourse = new SelectedCourse(courseId, studentId, mark, examTime);
			}
		} catch (SQLException e) {
			conn.close();
			e.printStackTrace();
		}
		return sCourse;
	}
	
	// 选择成绩记录
	public SC selectStudentScore(SC sc1) {
		String sql = "select selectedcourse.studentID, student.userName, selectedcourse.courseID, courseName, mark "
				+ "from selectedcourse, student, course "
				+ "where selectedcourse.studentID = student.userID and "
				+ "selectedcourse.courseID = course.courseID and "
				+ "student.userName = '"
				+ sc1.getStudentName()
				+ "' and courseName = '"
				+ sc1.getCourseName()
				+ "' and selectedcourse.studentID = "
				+ sc1.getStudentId()
				+ " and course.courseID = "
				+ sc1.getCourseId()
				+ " and mark = "
				+ sc1.getMark();
		System.out.println(sql);
		ResultSet rs = conn.find(sql);
		sc = null;
		try {
			while(rs.next()) {
				int courseID = rs.getInt("courseID");
				String courseName = rs.getString("courseName");
				int studentID = rs.getInt("studentID");
				String studentName = rs.getString("userName");
				int mark = rs.getInt("mark");
				sc = new SC(studentID, studentName, courseID, courseName, mark);
			}
		} catch (SQLException e) {
			conn.close();
			e.printStackTrace();
		}
		return sc;
	}
	
	// 查询学生所有成绩
	public List<SelectedCourse> findOne(String studentName) {
		List<SelectedCourse> list = new ArrayList<SelectedCourse>();
		String sql = "select * from selectedcourse where studentID = '"
				+ studentName
				+ "'";
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
	public List<SC> findStuOne(String studentName, String courseName) {
		List<SC> list = new ArrayList<SC>();
		String sql = "select selectedcourse.studentID, student.userName, selectedcourse.courseID, course.courseName, mark "
				+ "from selectedcourse, student, course "
				+ "where selectedcourse.courseID = course.courseID "
				+ "and selectedcourse.studentID = student.userID "
				+ "and studentID = "
				+"'"
				+ studentName
				+"'"
				+ " and courseName = '"
				+ courseName
				+ "'";
		ResultSet rs = conn.find(sql);
		try {
			while(rs.next()) {
				int studentID = rs.getInt("studentID");
				String studentname = rs.getString("userName");
				int courseID = rs.getInt("courseID");
				String coursename = rs.getString("courseName");
				int mark = rs.getInt("mark");
				sc = new SC(studentID, studentname, courseID, coursename, mark);
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
				+ studentId;
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
				+ "'";
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
	public PageBean scTeaPageList(int pageNo, int pageCount, String teacherName) {
		int totalCount = 0;
		List<SC> list = new ArrayList<SC>();
		String sql = "select studentID, student.userName, course.courseID, courseName, mark from "
				+ "selectedcourse, student, course, teacher where "
				+ "selectedcourse.courseID = course.courseID and "
				+ "selectedcourse.studentID = student.userID and "
				+ "course.teacherID = teacher.userID and "
				+ "teacher.userID = "
				+ teacherName
				+ " limit " 
				+ ((pageNo - 1) * pageCount) 
				+ ", " 
				+ pageCount;
		String sqlCount = "select count(*) from "
				+ "selectedcourse, student, course, teacher where "
				+ "selectedcourse.courseID = course.courseID and "
				+ "selectedcourse.studentID = student.userID and "
				+ "course.teacherID = teacher.userID and "
				+ "teacher.userID = "
				+ teacherName;
		ResultSet rs = conn.find(sql);
		try {
			while(rs.next()) {
				int studentId = rs.getInt("studentID");
				int courseId = rs.getInt("courseID");
				int mark = rs.getInt("mark");
				String studentName = rs.getString("userName");
				String courseName = rs.getString("courseName");
				sc = new SC(studentId, studentName, courseId, courseName, mark);
				list.add(sc);
				System.out.println(sc.getStudentName());
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
	
	// 可选课程展示
	public PageBean courseCanChoose(int pageNo, int pageCount, String studentName) {
		int totalCount = 0;
		List<CosCInfo> list = new ArrayList<CosCInfo>();
		// 先确定该学生所在学院
		String sqlPre = "select collegeID from student where userID = '" 
				+ studentName
				+ "'";
		ResultSet rs = conn.find(sqlPre);
		int collegeId = 0;
		try {
			while(rs.next()) {
				collegeId = rs.getInt("collegeID");
			}
		} catch (SQLException e) {
			conn.close();
			e.printStackTrace();
		}
		// 选择该学院下有效的课程进行展示
		String sql = "select course.courseID, courseName, teacher.userName, courseType, courseTime, classRoom, courseWeek "
				+ "from course, courseinfo, teacher where "
				+ "course.courseID = courseinfo.courseID and "
				+ "course.teacherID = teacher.userID and "
				+ "courseinfo.collegeID = "
				+ collegeId
				+ " and SON = 1 "
				+ "and courseType = '选修课'"
				+ " limit "
				+ ((pageNo - 1) * pageCount)
				+ ", "
				+ pageCount;
		String sqlCount = "select count(*) "
				+ "from course, courseinfo, teacher where "
				+ "course.courseID = courseinfo.courseID and "
				+ "course.teacherID = teacher.userID and "
				+ "courseinfo.collegeID = "
				+ collegeId
				+ " and SON = 1"
				+ " and courseType = '选修课'";
		rs = conn.find(sql);
		try {
			while(rs.next()) {
				int courseId = rs.getInt("courseID");
				String courseName = rs.getString("courseName");
				String teacherName = rs.getString("userName");
				String courseType = rs.getString("courseType");
				String courseTime = rs.getString("courseTime");
				String courseRoom = rs.getString("classRoom");
				int courseWeek = rs.getInt("courseWeek");
				cInfo = new CosCInfo(courseId, courseName, teacherName, courseType, courseTime, courseRoom, courseWeek);
				list.add(cInfo);
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
	
	// 显示学生已选课程
	public PageBean selectedCourseShow(int pageNo, int pageCount, String studentName) {
		int totalCount = 0;
		List<CosCInfo> list = new ArrayList<CosCInfo>();
		String sql = "select course.courseID, courseName, teacher.userName, courseType, courseWeek, courseTime, classRoom "
				+ "from course, courseinfo, teacher, selectedcourse, student where "
				+ "course.courseID = courseinfo.courseID and "
				+ "course.teacherID = teacher.userID and "
				+ "course.courseID = selectedcourse.courseID and "
				+ "selectedcourse.studentID = student.userID and "
				+ "student.userID = "
				+ studentName
				+ " limit "
				+ ((pageNo - 1) * pageCount)
				+ ", "
				+ pageCount;
		String sqlCount = "select count(*) "
				+ "from course, courseinfo, teacher, selectedcourse, student where "
				+ "course.courseID = courseinfo.courseID and "
				+ "course.teacherID = teacher.userID and "
				+ "course.courseID = selectedcourse.courseID and "
				+ "selectedcourse.studentID = student.userID and "
				+ "student.userID = "
				+ studentName;
		ResultSet rs = conn.find(sql);
		try {
			while(rs.next()) {
				int courseId = rs.getInt("courseID");
				String courseName = rs.getString("courseName");
				String teacherName = rs.getString("userName");
				String courseType = rs.getString("courseType");
				String courseTime = rs.getString("courseTime");
				String courseRoom = rs.getString("classRoom");
				int courseWeek = rs.getInt("courseWeek");
				cInfo = new CosCInfo(courseId, courseName, teacherName, courseType, courseTime, courseRoom, courseWeek);
				list.add(cInfo);
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
	public PageBean teacherCourse(int pageNo, int pageCount, String teacherName) {
		int totalCount = 0;
		List<TC> list = new ArrayList<TC>();
		String sql = "select teacher.userID, userName, course.courseID, courseName, examtime "
				+ "from teacher, course, selectedcourse "
				+ "where course.teacherID = teacher.userID "
				+ "and course.courseID = selectedcourse.courseID "
				+ "and course.teacherName = '"
				+ teacherName
				+ "' limit "
				+ ((pageNo - 1) * pageCount)
				+ ", "
				+ pageCount;
		String sqlCount = "select count(*) "
				+ "from teacher, course, selectedcourse "
				+ "where course.teacherID = teacher.userID "
				+ "and course.courseID = selectedcourse.courseID "
				+ "and course.teacherName = '"
				+ teacherName
				+ "'";
		ResultSet rs = conn.find(sql);
		try {
			while(rs.next()) {
				int teacherID = rs.getInt("userID");
				String teachername = rs.getString("teacherName");
				int courseID = rs.getInt("courseID");
				String courseName = rs.getString("courseName");
				Date examTime = rs.getDate("examtime");
				tc = new TC(teacherID, teachername, courseID, courseName, examTime);
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
	
	// 教师管理学生成绩
	public PageBean selectStuScore(int pageNo, int pageCount, String teacherName) {
		int totalCount = 0;
		List<SC> list = new ArrayList<SC>();
		String sql = "select selectedcourse.studentID, student.userName, selectedcourse.courseID, course.courseName, teacher.userName, mark "
				+ "from selectedcourse, student, course, teacher "
				+ "where selectedcourse.studentID = student.userID and "
				+ "selectedcourse.courseID = course.courseID and "
				+ "course.teacherID = teacher.userID and "
				+ "teacher.userID = "
				+ teacherName
				+ " limit "
				+ ((pageNo - 1) * pageCount)
				+ ", "
				+ pageCount;
		String sqlCount = "select count(*) from selectedcourse, student, course, teacher "
				+ "where selectedcourse.studentID = student.userID and "
				+ "selectedcourse.courseID = course.courseID and "
				+ "course.teacherID = teacher.userID and "
				+ "teacher.userID = "
				+ teacherName;
		ResultSet rs = conn.find(sql);
		try {
			while(rs.next()) {
				int studentId = rs.getInt("studentID");
				String studentName = rs.getString("userName");
				int courseId = rs.getInt("courseID");
				String courseName = rs.getString("courseName");
				int mark = rs.getInt("mark");
				sc = new SC(studentId, studentName, courseId, courseName, mark);
				list.add(sc);
				System.out.println(sc.getCourseId());
				System.out.println(sc.getCourseName());
				System.out.println(sc.getStudentName());
				System.out.println(sc.getMark());
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
