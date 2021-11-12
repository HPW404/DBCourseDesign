package service;

import java.util.List;

import model.Student;
import model.PageBean;

public interface StudentService {
	// 增加学生
	int addStudent(Student student, String birthYear, String grade);
	
	// 删除学生
	int deleteStudent(int stuId);
	
	// 编辑学生
	int editStudent(Student student, String birthYear, String grade);
	
	// 查看所有学生
	List<Student> findAll();
	
	// 查询单个学生
	List<Student> findOne(int stuId);
	
	// 分页查询学生
	PageBean stuPageList(int pageNo, int pageCount);
}
