package dao;

import java.util.List;

import model.Student;
import model.PageBean;

public interface StudentDao {
	// ���ѧ��
	int addStudent(Student student, String birthYear, String grade);
	
	// ɾ��ѧ��
	int deleteStudent(int stuId);
	
	// �༭ѧ��
	int editStudent(Student student, String birthYear, String grade);
	
	// ��ѯ����ѧ��
	List<Student> findAll();
	
	// ��ѯĳһ��ѧ��
	List<Student> findOne(int stuId);
	
	// ʵ�ַ�ҳ��ѯ
	PageBean stuListPage(int pageNo, int pageCount);
}
