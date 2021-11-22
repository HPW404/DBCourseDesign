package dao;

import java.util.List;

import model.Graduate;
import model.PageBean;

public interface GraduateDao {
	// ��ӱ�ҵ��
	int addGraduate(Graduate graduate, String birthYear, String grade, String graduateTime);
	
	// �༭��ҵ��
	int editGraduate(Graduate graduate, String birthYear, String grade, String graduateTime);
	
	// ɾ����ҵ��
	int deleteGraduate(int userId);
	
	// ѡ���ҵ��
	Graduate selectGraduate(Graduate graduate);
	
	// �鿴���б�ҵ��
	List<Graduate> findAll();
	
	// ��ѯĳ����ҵ��
	List<Graduate> findOne(int userId);
	
	// ��ҳ��ѯ
	PageBean graduatePageList(int pageNo, int pageCount);
}
