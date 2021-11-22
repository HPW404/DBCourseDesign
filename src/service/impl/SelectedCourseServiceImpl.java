package service.impl;

import java.util.List;

import dao.impl.SelectedCourseDaoImpl;
import model.SelectedCourse;
import model.TC;
import model.SC;
import model.PageBean;
import service.SelectedCourseService;

public class SelectedCourseServiceImpl implements SelectedCourseService {
	private SelectedCourseDaoImpl selectedCourseDaoImpl = new SelectedCourseDaoImpl();
	
	public int addSelectedCourse(SelectedCourse sCourse, String examTime) {
		int rs = selectedCourseDaoImpl.addSelectedCourse(sCourse, examTime);
		return rs;
	}
	
	public int editSelectedCourse(SelectedCourse sCourse, String examTime) {
		int rs = selectedCourseDaoImpl.editSelectedCourse(sCourse, examTime);
		return rs;
	}
	
	public int deleteSelectedCourse(int studentId, int courseId) {
		int rs = selectedCourseDaoImpl.deleteSelectedCourse(studentId, courseId);
		return rs;
	}
	
	public List<SelectedCourse> findOne(int studentId) {
		List<SelectedCourse> rs = selectedCourseDaoImpl.findOne(studentId);
		return rs;
	}
	
	public List<SC> findStuOne(int studentId, int courseId) {
		List<SC> rs = selectedCourseDaoImpl.findStuOne(studentId, courseId);
		return rs;
	}
	
	public SelectedCourse selectCourseInfo(SelectedCourse sCourse) {
		SelectedCourse rs = selectedCourseDaoImpl.selectCourseInfo(sCourse);
		return rs;
	}
	
	public PageBean scPageList(int pageNo, int pageCount, int studentId) {
		PageBean rs = selectedCourseDaoImpl.scPageList(pageNo, pageCount, studentId);
		return rs;
	}
	
	public PageBean scPageList(int pageNo, int pageCount, String studentName) {
		PageBean rs = selectedCourseDaoImpl.scPageList(pageNo, pageCount, studentName);
		return rs;
	}
	
	public PageBean scPageList(int pageNo, int pageCount) {
		PageBean rs = selectedCourseDaoImpl.scPageList(pageNo, pageCount);
		return rs;
	}
	
	public PageBean teacherCourse(int pageNo, int pageCount, int teacherId, TC tc) {
		PageBean rs = selectedCourseDaoImpl.teacherCourse(pageNo, pageCount, teacherId, tc);
		return rs;
	}
}
