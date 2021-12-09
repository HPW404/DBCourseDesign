package service.Impl;

import java.util.List;

import dao.Impl.SelectedCourseDaoImpl;
import model.SelectedCourse;
import model.SC;
import model.CosCInfo;
import model.PageBean;
import service.SelectedCourseService;

public class SelectedCourseServiceImpl implements SelectedCourseService {
	
	private SelectedCourseDaoImpl selectedCourseDaoImpl = new SelectedCourseDaoImpl();
	
	public int addSelectedCourse(SelectedCourse sCourse) {
		int rs = selectedCourseDaoImpl.addSelectedCourse(sCourse);
		return rs;
	}
	
	public int addScore(SelectedCourse selectedCourse) {
		int rs = selectedCourseDaoImpl.addScore(selectedCourse);
		return rs;
	}
	
	public int addScore(SC sc) {
		int rs = selectedCourseDaoImpl.addScore(sc);
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
	
	public int editExamTime(String courseName, String examTime) {
		int rs = selectedCourseDaoImpl.editExamTime(courseName, examTime);
		return rs;
	}
	
	public CosCInfo selectSelectedCourse(CosCInfo cInfo) {
		CosCInfo rs = selectedCourseDaoImpl.selectSelectedCourse(cInfo);
		return rs;
	}
	
	public SelectedCourse selectSelectedCourse(SelectedCourse selectedCourse) {
		SelectedCourse rs = selectedCourseDaoImpl.selectSelectedCourse(selectedCourse);
		return rs;
	}
	
	public SC selectStudentScore(SC sc) {
		SC rs = selectedCourseDaoImpl.selectStudentScore(sc);
		return rs;
	}
	
	public List<SelectedCourse> findOne(String studentName) {
		List<SelectedCourse> rs = selectedCourseDaoImpl.findOne(studentName);
		return rs;
	}
	
	public List<SC> findStuOne(String studentName, String courseName) {
		List<SC> rs = selectedCourseDaoImpl.findStuOne(studentName, courseName);
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
	
	public PageBean scTeaPageList(int pageNo, int pageCount, String teacherName) {
		PageBean rs = selectedCourseDaoImpl.scTeaPageList(pageNo, pageCount, teacherName);
		return rs;
	}
	
	public PageBean courseCanChoose(int pageNo, int pageCount, String studentName) {
		PageBean rs = selectedCourseDaoImpl.courseCanChoose(pageNo, pageCount, studentName);
		return rs;
	}
	
	public PageBean selectedCourseShow(int pageNo, int pageCount, String studentName) {
		PageBean rs = selectedCourseDaoImpl.selectedCourseShow(pageNo, pageCount, studentName);
		return rs;
	}
	
	public PageBean teacherCourse(int pageNo, int pageCount, String teacherName) {
		PageBean rs = selectedCourseDaoImpl.teacherCourse(pageNo, pageCount, teacherName);
		return rs;
	}
	
	public PageBean selectStuScore(int pageNo, int pageCount, String teacherName) {
		PageBean rs = selectedCourseDaoImpl.selectStuScore(pageNo, pageCount, teacherName);
		return rs;
	}
}
