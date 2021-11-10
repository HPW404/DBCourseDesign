package dao;

import java.util.List;

import model.Student;
import model.PageBean;

public interface StudentDao {
	// 添加学生
	int addStudent(Student student, String birthYear, String grade);
	
	// 删除学生
	int deleteStudent(int stuId);
	
	// 编辑学生
	int editStudent(Student student, String birthYear, String grade);
	
	// 查询所有学生
	List<Student> findAll();
	
	// 查询某一个学生
	List<Student> findOne(int stuId);
	
	// 实现分页查询
	PageBean stuListPage(int pageNo, int pageCount);
}
