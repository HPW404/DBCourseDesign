package service.Impl;

import java.util.List;

import dao.Impl.UserDaoImpl;
import model.UserLogin;
import service.UserService;

public class UserServiceImpl implements UserService{
	
	private UserDaoImpl userDaoImpl = new UserDaoImpl();

	public UserLogin login(UserLogin userLogin) {
		UserLogin rs = userDaoImpl.login(userLogin);
		return rs;
	}

	public int editPassword(UserLogin userLogin) {
		int rs=userDaoImpl.editPassword(userLogin);
		return rs;
	}

	public int addUser(UserLogin userLogin) {
		int rs = userDaoImpl.addUser(userLogin);
		return rs;
	}

	public List<UserLogin> findAll() {
		List<UserLogin> rs = userDaoImpl.findAll();
		return rs;
	}

	public List<UserLogin> findOne(int userID) {
		List<UserLogin> rs = userDaoImpl.findOne(userID);
		return rs;
	}

	public int editUser(UserLogin userLogin) {
		int rs = userDaoImpl.editUser(userLogin);
		return rs;
	}

}
