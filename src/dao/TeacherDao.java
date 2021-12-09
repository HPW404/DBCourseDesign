package dao;

import java.util.Date;
import java.util.List;

import model.Teacher;
import model.PageBean;

public interface TeacherDao {
	// 添加教师
	int addTeacher(Teacher teacher, String birthYear, String grade);
	
	// 删除教师
	int deleteTeacher(int teacherId);
	
	// 编辑教师
	int editTeacher(Teacher teacher, int teacherId,String teacherName,String sex,Date birthYear,String degree,String title,Date grade,int collegeId);
	
	// 查看所有教师
	List<Teacher> findAll();
	
	// 查找某位教师
	List<Teacher> findOne(int teacherId);
	
	// 分页查询教师
	PageBean teacherPageList(int pageNo, int pageCount);
}
