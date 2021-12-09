package dao;

import java.util.List;

import model.SelectedCourse;
import model.CosCInfo;
import model.PageBean;
import model.SC;

public interface SelectedCourseDao {
	// 增加选课记录
	int addSelectedCourse(SelectedCourse sCourse);
	
	// 增加成绩记录
	int addScore(SelectedCourse selectedCourse);
	
	// 添加成绩记录
	int addScore(SC sc);
	
	// 编辑选课记录（成绩）
	int editSelectedCourse(SelectedCourse sCourse, String examTime);
	
	// 删除选课记录
	int deleteSelectedCourse(int studentId, int courseId);
	
	// 编辑考试时间
	int editExamTime(String courseName, String examTime);
	
	// 选择选课记录
	CosCInfo selectSelectedCourse(CosCInfo cInfo);
	
	// 选择成绩记录
	SelectedCourse selectSelectedCourse(SelectedCourse selectedCourse);
	
	// 选择成绩记录
	SC selectStudentScore(SC sc);
	
	// 查看所有成绩
	List<SelectedCourse> findOne(String studentName);
	
	// 查看单个学生单科成绩
	List<SC> findStuOne(String studentName, String courseName);
	
	// 查询该学生的该课程是否添加
	SelectedCourse selectCourseInfo(SelectedCourse sCourse);
	
	// 分页显示一个学生成绩信息（使用学号查询）
	PageBean scPageList(int pageNo, int pageCount, int studentId);
	
	// 分页显示一个学生成绩信息（使用姓名查询）
	PageBean scPageList(int pageNo, int pageCount, String studentName);
	
	// 分页显示成绩
	PageBean scTeaPageList(int pageNo, int pageCount, String teacherName);
	
	// 展示可选课程
	PageBean courseCanChoose(int pageNo, int pageCount, String studentName);
	
	// 显示学生已选课程
	PageBean selectedCourseShow(int pageNo, int pageCount, String studentName);
	
	// 显示教师所带课程
	PageBean teacherCourse(int pageNo, int pageCount, String teacherName);
	
	// 教师管理学生成绩
	PageBean selectStuScore(int pageNo, int pageCount, String teacherName);
}
