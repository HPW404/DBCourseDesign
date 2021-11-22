package service;

import java.util.List;

import model.College;
import model.PageBean;

public interface CollegeService {
	// 添加学院
	int addCollege(College college);
	
	// 删除学院
	int deleteCollege(int collegeId);
	
	// 编辑学院
	int editCollege(College college);
	
	// 选择学院
	College selectCollege(College college);
	
	// 查看所有学院
	List<College> findAll();
	
	// 查询某个学院
	List<College> findOne(int collegeId);
	
	// 分页查询学院
	PageBean collegePageList(int pageNo, int pageCount);
}
