package service.Impl;

import java.util.Date;
import java.util.List;

import dao.Impl.TeacherDaoImpl;
import model.Teacher;
import model.PageBean;
import service.TeacherService;

public class TeacherServiceImpl implements TeacherService {
	private TeacherDaoImpl teacherDaoImpl = new TeacherDaoImpl();
	
	public int addTeacher(Teacher teacher, String birthYear, String grade) {
		int rs = teacherDaoImpl.addTeacher(teacher, birthYear, grade);
		return rs;
	}
	
	public int deleteTeacher(int teacherId) {
		int rs = teacherDaoImpl.deleteTeacher(teacherId);
		return rs;
	}
	
	public int editTeacher(Teacher teacher,int teacherId,String teacherName,String sex,Date birthYear,String degree,String title,Date grade,int collegeId) {
		int rs = teacherDaoImpl.editTeacher(teacher, teacherId, teacherName, sex, birthYear, degree, title, grade, collegeId);
		return rs;
	}
	
	public List<Teacher> findAll() {
		List<Teacher> rs = teacherDaoImpl.findAll();
		return rs;
	}
	
	public List<Teacher> findOne(int teacherId) {
		List<Teacher> rs = teacherDaoImpl.findOne(teacherId);
		return rs;
	}
	
	public PageBean teacherPageList(int pageNo, int pageCount) {
		PageBean rs = teacherDaoImpl.teacherPageList(pageNo, pageCount);
		return rs;
	}
}
