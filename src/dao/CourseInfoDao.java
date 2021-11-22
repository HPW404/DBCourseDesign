package dao;

import java.util.List;

import model.CourseInfo;
import model.PageBean;

public interface CourseInfoDao {
	// ��ӿγ���Ϣ
	int addCourseInfo(CourseInfo courseInfo);
	
	// ɾ���γ���Ϣ
	int deleteCourseInfo(int courseId);
	
	// �༭�γ���Ϣ
	int editCourseInfo(CourseInfo courseInfo);
	
	// ѡ��γ���Ϣ
	CourseInfo selectCourseInfo(CourseInfo courseInfo);
	
	// �鿴���пγ̵Ŀγ���Ϣ
	List<CourseInfo> findAll();
	
	// �鿴ĳһ�γ̵Ŀγ���Ϣ
	List<CourseInfo> findOne(int courseId);
	
	// ��ҳ��ѯ�γ���Ϣ
	PageBean courseInfoPageList(int pageNo, int pageCount);
}
