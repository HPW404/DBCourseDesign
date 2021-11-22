package service;

import java.util.List;

import model.SelectedCourse;
import model.TC;
import model.PageBean;
import model.SC;

public interface SelectedCourseService {
	// 增加选课记录
	int addSelectedCourse(SelectedCourse sCourse, String examTime);
	
	// 编辑选课记录（成绩）
	int editSelectedCourse(SelectedCourse sCourse, String examTime);
	
	// 删除选课记录
	int deleteSelectedCourse(int studentId, int courseId);
	
	// 查看所有成绩
	List<SelectedCourse> findOne(int studentId);
	
	// 查看单个学生单科成绩
	List<SC> findStuOne(int studentId, int courseId);
	
	// 查询该学生的该课程是否添加
	SelectedCourse selectCourseInfo(SelectedCourse sCourse);
	
	// 分页显示一个学生成绩信息（使用学号查询）
	PageBean scPageList(int pageNo, int pageCount, int studentId);
	
	// 分页显示一个学生成绩信息（使用姓名查询）
	PageBean scPageList(int pageNo, int pageCount, String studentName);
	
	// 分页显示成绩
	PageBean scPageList(int pageNo, int pageCount);
	
	// 显示教师所带课程
	PageBean teacherCourse(int pageNo, int pageCount, int teacherId, TC tc);
}
