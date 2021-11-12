package service;

import java.util.List;

import model.Student;
import model.PageBean;

public interface StudentService {
	// ����ѧ��
	int addStudent(Student student, String birthYear, String grade);
	
	// ɾ��ѧ��
	int deleteStudent(int stuId);
	
	// �༭ѧ��
	int editStudent(Student student, String birthYear, String grade);
	
	// �鿴����ѧ��
	List<Student> findAll();
	
	// ��ѯ����ѧ��
	List<Student> findOne(int stuId);
	
	// ��ҳ��ѯѧ��
	PageBean stuPageList(int pageNo, int pageCount);
}
