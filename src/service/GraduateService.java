package service;

import java.util.List;

import model.Graduate;
import model.PageBean;

public interface GraduateService {
	// 增加毕业生
	int addGraduate(Graduate graduate, String birthYear, String grade, String graduateTime);
	
	// 删除毕业生
	int deleteGraduate(int userId);
	
	// 编辑毕业生
	int editGraduate(Graduate graduate, String birthYear, String grade, String graduateTime);
	
	// 选择毕业生
	Graduate selectGraduate(Graduate graduate);
	
	// 查看所有毕业生
	List<Graduate> findAll();
	
	// 查询单个毕业生
	List<Graduate> findOne(int userId);
	
	// 分页查询毕业生
	PageBean graduatePageList(int pageNo, int pageCount);
}
