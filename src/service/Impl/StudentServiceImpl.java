package service.Impl;

import java.util.List;

import dao.Impl.StudentDaoImpl;
import model.Student;
import model.PageBean;
import service.StudentService;

public class StudentServiceImpl implements StudentService {
	private StudentDaoImpl studentDaoImpl = new StudentDaoImpl();
	
	public int addStudent(Student student, String birthYear, String grade) {
		int rs = studentDaoImpl.addStudent(student, birthYear, grade);
		return rs;
	}
	
	public int deleteStudent(String stuId) {
		int rs = studentDaoImpl.deleteStudent(stuId);
		return rs;
	}
	
	public int editStudent(Student student, int collegeId, String studentName) {
		int rs = studentDaoImpl.editStudent(student, collegeId,studentName);
		return rs;
	}
	public int editStudent(Student student) {
		int rs = studentDaoImpl.editStudent(student);
		return rs;
	}
	public List<Student> findAll() {
		List<Student> rs = studentDaoImpl.findAll();
		return rs;
	}
	
	public List<Student> findOne(String stuId) {
		List<Student> rs = studentDaoImpl.findOne(stuId);
		return rs;
	}
	
	public PageBean stuPageList(int pageNo, int pageCount) {
		PageBean rs = studentDaoImpl.stuPageList(pageNo, pageCount);
		return rs;
	}
}
