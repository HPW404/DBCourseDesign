package dao;

import java.util.List;

import model.SelectedCourse;
import model.CosCInfo;
import model.PageBean;
import model.SC;

public interface SelectedCourseDao {
	// ����ѡ�μ�¼
	int addSelectedCourse(SelectedCourse sCourse);
	
	// ���ӳɼ���¼
	int addScore(SelectedCourse selectedCourse);
	
	// ��ӳɼ���¼
	int addScore(SC sc);
	
	// �༭ѡ�μ�¼���ɼ���
	int editSelectedCourse(SelectedCourse sCourse, String examTime);
	
	// ɾ��ѡ�μ�¼
	int deleteSelectedCourse(int studentId, int courseId);
	
	// �༭����ʱ��
	int editExamTime(String courseName, String examTime);
	
	// ѡ��ѡ�μ�¼
	CosCInfo selectSelectedCourse(CosCInfo cInfo);
	
	// ѡ��ɼ���¼
	SelectedCourse selectSelectedCourse(SelectedCourse selectedCourse);
	
	// ѡ��ɼ���¼
	SC selectStudentScore(SC sc);
	
	// �鿴���гɼ�
	List<SelectedCourse> findOne(String studentName);
	
	// �鿴����ѧ�����Ƴɼ�
	List<SC> findStuOne(String studentName, String courseName);
	
	// ��ѯ��ѧ���ĸÿγ��Ƿ����
	SelectedCourse selectCourseInfo(SelectedCourse sCourse);
	
	// ��ҳ��ʾһ��ѧ���ɼ���Ϣ��ʹ��ѧ�Ų�ѯ��
	PageBean scPageList(int pageNo, int pageCount, int studentId);
	
	// ��ҳ��ʾһ��ѧ���ɼ���Ϣ��ʹ��������ѯ��
	PageBean scPageList(int pageNo, int pageCount, String studentName);
	
	// ��ҳ��ʾ�ɼ�
	PageBean scTeaPageList(int pageNo, int pageCount, String teacherName);
	
	// չʾ��ѡ�γ�
	PageBean courseCanChoose(int pageNo, int pageCount, String studentName);
	
	// ��ʾѧ����ѡ�γ�
	PageBean selectedCourseShow(int pageNo, int pageCount, String studentName);
	
	// ��ʾ��ʦ�����γ�
	PageBean teacherCourse(int pageNo, int pageCount, String teacherName);
	
	// ��ʦ����ѧ���ɼ�
	PageBean selectStuScore(int pageNo, int pageCount, String teacherName);
}
