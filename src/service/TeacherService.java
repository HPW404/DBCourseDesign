package service;

import java.util.Date;
import java.util.List;

import model.Teacher;
import model.PageBean;

public interface TeacherService {
	// ���ӽ�ʦ
	int addTeacher(Teacher teacher, String birthYear, String grade);
	
	// ɾ����ʦ
	int deleteTeacher(int teacherId);
	
	// �༭��ʦ
	int editTeacher(Teacher teacher,int teacherId,String teacherName,String sex,Date birthYear,String degree,String title,Date grade,int collegeId);
	
	// �鿴���н�ʦ
	List<Teacher> findAll();
	
	// ��ѯ������ʦ
	List<Teacher> findOne(int teacherId);
	
	// ��ҳ��ѯ��ʦ
	PageBean teacherPageList(int pageNo, int pageCount);
}
