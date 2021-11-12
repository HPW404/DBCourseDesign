package service.impl;

import java.util.List;

import dao.impl.StudentDaoImpl;
import model.Student;
import model.PageBean;
import service.StudentService;

public class StudentServiceImpl implements StudentService {
	private StudentDaoImpl studentDaoImpl = new StudentDaoImpl();
	
	public int addStudent(Student student, String birthYear, String grade) {
		int rs = studentDaoImpl.addStudent(student, birthYear, grade);
		return rs;
	}
	
	public int deleteStudent(int stuId) {
		int rs = studentDaoImpl.deleteStudent(stuId);
		return rs;
	}
	
	public int editStudent(Student student, String birthYear, String grade) {
		int rs = studentDaoImpl.editStudent(student, birthYear, grade);
		return rs;
	}
	
	public List<Student> findAll() {
		List<Student> rs = studentDaoImpl.findAll();
		return rs;
	}
	
	public List<Student> findOne(int stuId) {
		List<Student> rs = studentDaoImpl.findOne(stuId);
		return rs;
	}
	
	public PageBean stuPageList(int pageNo, int pageCount) {
		PageBean rs = studentDaoImpl.stuPageList(pageNo, pageCount);
		return rs;
	}
}
