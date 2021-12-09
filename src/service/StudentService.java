package service;

import java.util.List;

import model.Student;
import model.PageBean;

public interface StudentService {
	// 增加学生
	int addStudent(Student student, String birthYear, String grade);
	
	// 删除学生
	int deleteStudent(String stuId);
	
	// 编辑学生
	int editStudent(Student student,int collegeId, String studentName);
	
	// 查看所有学生
	List<Student> findAll();
	
	// 查询单个学生
	List<Student> findOne(String stuId);
	
	// 分页查询学生
	PageBean stuPageList(int pageNo, int pageCount);
}
