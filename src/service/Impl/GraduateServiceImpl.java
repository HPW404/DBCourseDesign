package service.Impl;

import java.util.List;

import dao.Impl.GraduateDaoImpl;
import model.Graduate;
import model.PageBean;
import service.GraduateService;

public class GraduateServiceImpl implements GraduateService {
	private GraduateDaoImpl graduateDaoImpl = new GraduateDaoImpl();
	
	public int addGraduate(Graduate graduate, String birthYear, String grade, String graduateTime) {
		int rs = graduateDaoImpl.addGraduate(graduate, birthYear, grade, graduateTime);
		return rs;
	}
	
	public int deleteGraduate(int userId) {
		int rs = graduateDaoImpl.deleteGraduate(userId);
		return rs;
	}
	
	public int editGraduate(Graduate graduate, String birthYear, String grade, String graduateTime) {
		int rs = graduateDaoImpl.editGraduate(graduate, birthYear, grade, graduateTime);
		return rs;
	}
	
	public Graduate selectGraduate(Graduate graduate) {
		Graduate rs = graduateDaoImpl.selectGraduate(graduate);
		return rs;
	}
	
	public List<Graduate> findAll() {
		List<Graduate> rs = graduateDaoImpl.findAll();
		return rs;
	}
	
	public List<Graduate> findOne(int userId) {
		List<Graduate> rs = graduateDaoImpl.findOne(userId);
		return rs;
	}
	
	public PageBean graduatePageList(int pageNo, int pageCount) {
		PageBean rs = graduateDaoImpl.graduatePageList(pageNo, pageCount);
		return rs;
	}
}
