package service.Impl;

import java.util.List;

import dao.Impl.CollegeDaoImpl;
import model.College;
import model.PageBean;
import service.CollegeService;

public class CollegeServiceImpl implements CollegeService {
	private CollegeDaoImpl collegeDaoImpl = new CollegeDaoImpl();
	
	public int addCollege(College college) {
		int rs = collegeDaoImpl.addCollege(college);
		return rs;
	}
	
	public int deleteCollege(int collegeId) {
		int rs = collegeDaoImpl.deleteCollege(collegeId);
		return rs;
	}
	
	public int editCollege(College college) {
		int rs = collegeDaoImpl.editCollege(college);
		return rs;
	}
	
	public College selectCollege(College college) {
		College rs = collegeDaoImpl.selectCollege(college);
		return rs;
	}
	
	public List<College> findAll() {
		List<College> rs = collegeDaoImpl.findAll();
		return rs;
	}
	
	public List<College> findOne(int collegeId) {
		List<College> rs = collegeDaoImpl.findOne(collegeId);
		return rs;
	}
	
	public PageBean collegePageList(int pageNo, int pageCount) {
		PageBean rs = collegeDaoImpl.collegePageList(pageNo, pageCount);
		return rs;
	}
}
