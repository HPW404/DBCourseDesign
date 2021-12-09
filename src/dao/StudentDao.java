package dao;

import java.util.List;

import model.Student;
import model.PageBean;

public interface StudentDao {
	// 添加学生
	int addStudent(Student student, String birthYear, String grade);
	
	// 删除学生
	int deleteStudent(String stuId);
	
	// 编辑学生
	int editStudent(Student student, int collegeId, String studentName);
	
	// 查询所有学生
	List<Student> findAll();
	
	// 查询某一个学生
	List<Student> findOne(String stuId);
	
	//Student findOne (Student student) ;
	
	// 实现分页查询
	PageBean stuPageList(int pageNo, int pageCount);
}
