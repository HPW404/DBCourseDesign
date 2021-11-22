package dao;

import java.util.List;

import model.Course;
import model.PageBean;

public interface CourseDao {
	// ��ӿγ�
	int addCourse(Course course);
	
	// ɾ���γ�
	int deleteCourse(int courseId);
	
	// �༭�γ�
	int editCourse(Course course);
	
	// �ı�γ�״̬
	int banCourse(Course course, int status);
	
	// �鿴���пγ�
	List<Course> findAll();
	
	// �鿴һ���γ�
	List<Course> findOne(int courseId);
	
	// ѡ��һ���γ�
	Course selectCourse(Course course);
	
	// ��ҳ��ѯ�γ�
	PageBean coursePageList(int pageNo, int pageCount);
}
