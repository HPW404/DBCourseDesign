package dao;

import java.util.List;
import model.UserLogin;

public interface UserDao {
	// 用户登录
	UserLogin login(UserLogin userLogin);
	
	// 修改密码
	int editPassword(UserLogin userLogin);
	
	// 修改账户信息
	int editUser(UserLogin userLogin);
	
	// 添加用户
	int addUser(UserLogin userLogin);
	
	// 查看所有用户
	List<UserLogin> findAll();
	
	// 查看单个用户
	List<UserLogin> findOne(int userId);
}
