package dao;

import java.util.List;

import model.Teacher;
import model.PageBean;

public interface TeacherDao {
	// ��ӽ�ʦ
	int addTeacher(Teacher teacher, String birthYear, String grade);
	
	// ɾ����ʦ
	int deleteTeacher(int teacherId);
	
	// �༭��ʦ
	int editTeacher(Teacher teacher, String birthYear, String grade);
	
	// �鿴���н�ʦ
	List<Teacher> findAll();
	
	// ����ĳλ��ʦ
	List<Teacher> findOne(int teacherId);
	
	// ��ҳ��ѯ��ʦ
	PageBean teacherPageList(int pageNo, int pageCount);
}
