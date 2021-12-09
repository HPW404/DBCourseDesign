package dao.Impl;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;

import model.Student;
import model.PageBean;
import db.DBCon;
import dao.StudentDao;

public class StudentDaoImpl implements StudentDao {
	private DBCon conn = new DBCon();
	private Student student = new Student();
	private PageBean pageBean;
	
	// 添加学生
	public int addStudent(Student student, String birthYear, String grade) {
		String sql = "insert into student(userID, userName, sex, birthYear, grade, collegeID) values ("
				+ student.getStuId() 
				+ ", '"
				+ student.getStuName() 
				+ "', '"
				+ student.getSex() 
				+ "', Date('"
				+ birthYear
				+ "'), Date('"
				+ grade 
				+ "'), "
				+ student.getCollegeId() 
				+ ")";
		int rs = conn.query(sql);
		return rs;
	}
	
	// 删除学生
	public int deleteStudent(String stuId) {
		String sql = "delete from student where userID = " + stuId;
		int rs = conn.query(sql);
		return rs;
	}
	
	// 编辑学生
	public int editStudent(Student student, int collegeId, String studentName) {
		String sql = "update student set userName = '" 
				+ studentName
				+"',collegeID='"
				+collegeId
				+ "' where userID = " 
				+ "'"
				+student.getStuId()
				+"'";
		int rs = conn.query(sql);
		System.out.println(sql);
		return rs;
	}
	public int editStudent(Student student) {
		String sql = "update student set userName = '" 
				+ student.getStuName()
				+ "', where collegeID = " 
				+ student.getCollegeId();
		int rs = conn.query(sql);
		return rs;
	}
	
	// 查询所有学生
	public List<Student> findAll() {
		List<Student> list = new ArrayList<Student>();
		String sql = "select * from student";
		ResultSet rs = conn.find(sql);
		try {
			while(rs.next()) {
				String stuId = rs.getString("userID");
				String stuName = rs.getString("userName");
				String sex = rs.getString("sex");
				Date birthYear = rs.getDate("birthYear");
				Date grade = rs.getDate("grade");
				int collegeId = rs.getInt("collegeID");
				student = new Student(stuId, stuName, sex, birthYear, grade, collegeId);
				list.add(student);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	// 查询单个学生
	public List<Student> findOne(String stuId) {
		List<Student> list = new ArrayList<Student>();
		String sql = "select * from student where userID = '"+ stuId+"'";
		System.out.println(sql);
		ResultSet rs = conn.find(sql);
		try {
			while(rs.next()) {
				String stuID = rs.getString("userID");
				String stuName = rs.getString("userName");
				String sex = rs.getString("sex");
				Date birthYear = rs.getDate("birthYear");
				Date grade = rs.getDate("grade");
				int collegeId = rs.getInt("collegeID");
				student = new Student(stuID, stuName, sex, birthYear, grade, collegeId);
				System.out.println(stuID);
				System.out.println(stuName);
				System.out.println(sex);
				System.out.println(grade);
				System.out.println(student.getStuId());
				list.add(student);
				System.out.println(list.get(0).getStuId());
				
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	//查询学生
	
	
	// 分页查询学生
	public PageBean stuPageList(int pageNo, int pageCount) {
		int totalCount = 0;
		List<Student> list = new ArrayList<Student>();
		String sql = "select * from student limit " 
				+ ((pageNo - 1) * pageCount) 
				+ "," 
				+ pageCount;
		String sqlCount = "select count(*) from student";
		
		try {
			ResultSet rs = conn.find(sql);
			while(rs.next()) {
				String stuId = rs.getString("userID");
				String stuName = rs.getString("userName");
				String sex = rs.getString("sex");
				Date birthYear = rs.getDate("birthYear");
				Date grade = rs.getDate("grade");
				int collegeId = rs.getInt("collegeID");
				student = new Student(stuId, stuName, sex, birthYear, grade, collegeId);
				list.add(student);
			}
			rs = conn.find(sqlCount);
			while(rs.next()){
				totalCount=rs.getInt(1); 
			}
			pageBean = new PageBean(list, totalCount, pageNo, pageCount);
		} catch (SQLException e) {
			conn.close();
			e.printStackTrace();
		}
		return pageBean;
	}
}
