package dao;

import java.util.List;

import model.CourseInfo;
import model.PageBean;

public interface CourseInfoDao {
	// 添加课程信息
	int addCourseInfo(CourseInfo courseInfo);
	
	// 删除课程信息
	int deleteCourseInfo(int courseId);
	
	// 编辑课程信息
	int editCourseInfo(CourseInfo courseInfo);
	
	// 选择课程信息
	CourseInfo selectCourseInfo(CourseInfo courseInfo);
	
	// 查看所有课程的课程信息
	List<CourseInfo> findAll();
	
	// 查看某一课程的课程信息
	List<CourseInfo> findOne(int courseId);
	
	// 分页查询课程信息
	PageBean courseInfoPageList(int pageNo, int pageCount);
}
