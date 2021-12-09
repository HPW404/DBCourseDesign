package service;

import java.util.List;

import model.Course;
import model.PageBean;

public interface CourseService {
	// ���ӿγ�
	int addCourse(Course course);
	
	// ɾ���γ�
	int deleteCourse(int courseId);
	
	// �༭�γ�
	int editCourse(Course course);
	
	// �ı�γ�״̬
	int banCourse(int courseId, int status);
	
	// �鿴���пγ�
	List<Course> findAll();
	
	// �鿴�����γ�
	List<Course> findOne(int courseId);
	
	// ѡ��һ�ſγ�
	Course selectCourse(Course course);
	
	// ��ҳ��ѯ�γ�
	PageBean coursePageList(int pageNo, int pageCount);
}
