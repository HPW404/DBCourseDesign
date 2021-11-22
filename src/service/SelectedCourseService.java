package service;

import java.util.List;

import model.SelectedCourse;
import model.TC;
import model.PageBean;
import model.SC;

public interface SelectedCourseService {
	// ����ѡ�μ�¼
	int addSelectedCourse(SelectedCourse sCourse, String examTime);
	
	// �༭ѡ�μ�¼���ɼ���
	int editSelectedCourse(SelectedCourse sCourse, String examTime);
	
	// ɾ��ѡ�μ�¼
	int deleteSelectedCourse(int studentId, int courseId);
	
	// �鿴���гɼ�
	List<SelectedCourse> findOne(int studentId);
	
	// �鿴����ѧ�����Ƴɼ�
	List<SC> findStuOne(int studentId, int courseId);
	
	// ��ѯ��ѧ���ĸÿγ��Ƿ����
	SelectedCourse selectCourseInfo(SelectedCourse sCourse);
	
	// ��ҳ��ʾһ��ѧ���ɼ���Ϣ��ʹ��ѧ�Ų�ѯ��
	PageBean scPageList(int pageNo, int pageCount, int studentId);
	
	// ��ҳ��ʾһ��ѧ���ɼ���Ϣ��ʹ��������ѯ��
	PageBean scPageList(int pageNo, int pageCount, String studentName);
	
	// ��ҳ��ʾ�ɼ�
	PageBean scPageList(int pageNo, int pageCount);
	
	// ��ʾ��ʦ�����γ�
	PageBean teacherCourse(int pageNo, int pageCount, int teacherId, TC tc);
}
