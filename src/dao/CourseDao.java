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
	int banCourse(Course course, int status);
	
	// 查看所有课程
	List<Course> findAll();
	
	// 查看一个课程
	List<Course> findOne(int courseId);
	
	// 分页查询课程
	PageBean courseListPage(int pageNo, int pageCount);
}
