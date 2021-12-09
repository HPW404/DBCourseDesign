package dao;

import java.util.List;

import model.Course;
import model.PageBean;

public interface CourseDao {
	// 添加课程
	int addCourse(Course course);
	
	// 删除课程
	int deleteCourse(int courseId);
	
	// 编辑课程
	int editCourse(Course course);
	
	// 改变课程状态
	int banCourse(int courseId, int status);
	
	// 查看所有课程
	List<Course> findAll();
	
	// 查看一个课程
	List<Course> findOne(int courseId);
	
	// 选择一个课程
	Course selectCourse(Course course);
	
	// 分页查询课程
	PageBean coursePageList(int pageNo, int pageCount);
}
