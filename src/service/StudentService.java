package service;

import java.util.List;

import model.Student;
import model.PageBean;

public interface StudentService {
	// ����ѧ��
	int addStudent(Student student, String birthYear, String grade);
	
	// ɾ��ѧ��
	int deleteStudent(String stuId);
	
	// �༭ѧ��
	int editStudent(Student student,int collegeId, String studentName);
	
	// �鿴����ѧ��
	List<Student> findAll();
	
	// ��ѯ����ѧ��
	List<Student> findOne(String stuId);
	
	// ��ҳ��ѯѧ��
	PageBean stuPageList(int pageNo, int pageCount);
}
