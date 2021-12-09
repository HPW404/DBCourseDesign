package service.Impl;

import java.util.List;

import dao.Impl.CourseInfoDaoImpl;
import model.CourseInfo;
import model.PageBean;
import service.CourseInfoService;

public class CourseInfoServiceImpl implements CourseInfoService {
	private CourseInfoDaoImpl courseInfoDaoImpl = new CourseInfoDaoImpl();
	
	public int addCourseInfo(CourseInfo courseInfo) {
		int rs = courseInfoDaoImpl.addCourseInfo(courseInfo);
		return rs;
	}
	
	public int deleteCourseInfo(int courseId) {
		int rs = courseInfoDaoImpl.deleteCourseInfo(courseId);
		return rs;
	}
	
	public int editCourseInfo(CourseInfo courseInfo) {
		int rs = courseInfoDaoImpl.editCourseInfo(courseInfo);
		return rs;
	}
	
	public CourseInfo selectCourseInfo(CourseInfo courseInfo) {
		CourseInfo rs = courseInfoDaoImpl.selectCourseInfo(courseInfo);
		return rs;
	}
	
	public List<CourseInfo> findAll() {
		List<CourseInfo> rs = courseInfoDaoImpl.findAll();
		return rs;
	}
	
	public List<CourseInfo> findOne(int courseId) {
		List<CourseInfo> rs = courseInfoDaoImpl.findOne(courseId);
		return rs;
	}
	
	public PageBean courseInfoPageList(int pageNo, int pageCount) {
		PageBean rs = courseInfoDaoImpl.courseInfoPageList(pageNo, pageCount);
		return rs;
	}
}
