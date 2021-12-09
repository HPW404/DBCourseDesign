package dao;

import java.util.List;

import model.Student;
import model.PageBean;

public interface StudentDao {
	// ���ѧ��
	int addStudent(Student student, String birthYear, String grade);
	
	// ɾ��ѧ��
	int deleteStudent(String stuId);
	
	// �༭ѧ��
	int editStudent(Student student, int collegeId, String studentName);
	
	// ��ѯ����ѧ��
	List<Student> findAll();
	
	// ��ѯĳһ��ѧ��
	List<Student> findOne(String stuId);
	
	//Student findOne (Student student) ;
	
	// ʵ�ַ�ҳ��ѯ
	PageBean stuPageList(int pageNo, int pageCount);
}
