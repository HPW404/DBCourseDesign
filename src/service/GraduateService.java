package service;

import java.util.List;

import model.Graduate;
import model.PageBean;

public interface GraduateService {
	// ���ӱ�ҵ��
	int addGraduate(Graduate graduate, String birthYear, String grade, String graduateTime);
	
	// ɾ����ҵ��
	int deleteGraduate(int userId);
	
	// �༭��ҵ��
	int editGraduate(Graduate graduate, String birthYear, String grade, String graduateTime);
	
	// ѡ���ҵ��
	Graduate selectGraduate(Graduate graduate);
	
	// �鿴���б�ҵ��
	List<Graduate> findAll();
	
	// ��ѯ������ҵ��
	List<Graduate> findOne(int userId);
	
	// ��ҳ��ѯ��ҵ��
	PageBean graduatePageList(int pageNo, int pageCount);
}
