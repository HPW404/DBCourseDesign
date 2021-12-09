package service.Impl;

import java.util.List;

import dao.Impl.CourseDaoImpl;
import model.Course;
import model.PageBean;
import service.CourseService;

public class CourseServiceImpl implements CourseService {
	private CourseDaoImpl courseDaoImpl = new CourseDaoImpl();
	
	public int addCourse(Course course) {
		int rs = courseDaoImpl.addCourse(course);
		return rs;
	}
	
	public int deleteCourse(int courseId) {
		int rs = courseDaoImpl.deleteCourse(courseId);
		return rs;
	}
	
	public int editCourse(Course course) {
		int rs = courseDaoImpl.editCourse(course);
		return rs;
	}
	
	public int banCourse(int courseId, int status) {
		int rs = courseDaoImpl.banCourse(courseId, status);
		return rs;
	}
	
	public List<Course> findAll() {
		List<Course> rs = courseDaoImpl.findAll();
		return rs;
	}
	
	public List<Course> findOne(int courseId) {
		List<Course> rs = courseDaoImpl.findOne(courseId);
		return rs;
	}
	
	public Course selectCourse(Course course) {
		Course rs = courseDaoImpl.selectCourse(course);
		return rs;
	}
	
	public PageBean coursePageList(int pageNo, int pageCount) {
		PageBean rs = courseDaoImpl.coursePageList(pageNo, pageCount);
		return rs;
	}
}
