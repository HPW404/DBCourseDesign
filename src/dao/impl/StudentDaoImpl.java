package dao.impl;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;

import model.Student;
import model.PageBean;
import util.JdbcUtil;
import dao.StudentDao;

public class StudentDaoImpl implements StudentDao {
	private JdbcUtil conn = new JdbcUtil();
	private Student student;
	private PageBean pageBean;
	
	// ���ѧ��
	public int addStudent(Student student, String birthYear, String grade) {
		String sql = "insert into student(userID, userName, sex, birthYear, grade, collegeID) values ("
				+ student.getStuId() + ", '"
				+ student.getStuName() + "', '"
				+ student.getSex() + "', Date('"
				+ student.getBirthYear() + "'), Date('"
				+ student.getGrade() + "'), "
				+ student.getCollegeId() + ")";
		int rs = conn.query(sql);
		return rs;
	}
	
	// ɾ��ѧ��
	public int deleteStudent(int stuId) {
		String sql = "delete from student where userID = " + stuId;
		int rs = conn.query(sql);
		return rs;
	}
	
	// �༭ѧ��
	public int editStudent(Student student, String birthYear, String grade) {
		String sql = "update student set userName = '" + student.getStuName()
				+ "', collegeID = " + student.getCollegeId();
		int rs = conn.query(sql);
		return rs;
	}
	
	// ��ѯ����ѧ��
	public List<Student> findAll() {
		List<Student> list = new ArrayList<Student>();
		String sql = "select * from student";
		ResultSet rs = conn.find(sql);
		try {
			while(rs.next()) {
				int stuId = rs.getInt("userID");
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
	
	// ��ѯ����ѧ��
	public List<Student> findOne(int stuId) {
		List<Student> list = new ArrayList<Student>();
		String sql = "select * from student where userID = " + stuId;
		ResultSet rs = conn.find(sql);
		try {
			while(rs.next()) {
				int stuID = rs.getInt("userID");
				String stuName = rs.getString("userName");
				String sex = rs.getString("sex");
				Date birthYear = rs.getDate("birthYear");
				Date grade = rs.getDate("grade");
				int collegeId = rs.getInt("collegeID");
				student = new Student(stuID, stuName, sex, birthYear, grade, collegeId);
				list.add(student);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	// ��ҳ��ѯѧ��
	public PageBean stuListPage(int pageNo, int pageCount) {
		int totalCount = 0;
		List<Student> list = new ArrayList<Student>();
		String sql = "select * from student limit " + ((pageNo - 1) * pageCount) + "," + pageCount;
		String sqlCount = "select count(*) from student";
		
		try {
			ResultSet rs = conn.find(sql);
			while(rs.next()) {
				int stuId = rs.getInt("userID");
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
