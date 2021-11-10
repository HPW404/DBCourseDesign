package dao.impl;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;

import model.UserLogin;
import dao.UserDao;
import util.JdbcUtil;


public class UserDaoImpl implements UserDao {
	private JdbcUtil conn = new JdbcUtil();
	private UserLogin userLogin;
	
	// 用户登录
	public UserLogin login(UserLogin userLogin) {
		String sql = "select * from userlogin where userID = " + userLogin.getUserId();
		ResultSet rs = conn.find(sql);
		try {
			while(rs.next()) {
				int userId = rs.getInt("userID");
				String userName = rs.getString("userName");
				String password = rs.getString("password");
				int role = rs.getInt("role");
				userLogin = new UserLogin(userId, userName, password, role);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userLogin;
	}
	
	// 修改密码
	public int editPassword(UserLogin userLogin) {
		String sql = "update userlogin set password = '" + userLogin.getPassword() 
				+ "' where userID = " + userLogin.getUserId();
		int rs = conn.query(sql);
		return rs;
	}
		
	// 修改账户信息
	public int editUser(UserLogin userLogin) {
		String sql = "update userlogin set userName = '" + userLogin.getUserName()
				+ "' where userID = " + userLogin.getUserId();
		int rs = conn.query(sql);
		return rs;
	}
	
	// 添加用户
	public int addUser(UserLogin userLogin) {
		String sql = "insert into userlogin(userID, userName, password, role) values("
				+ userLogin.getUserId() + ", '"
				+ userLogin.getUserName() + "', '"
				+ userLogin.getPassword() + "', "
				+ userLogin.getRole() + ")";
		int rs = conn.query(sql);
		return rs;
	}
	
	// 查看所有用户
	public List<UserLogin> findAll() {
		List<UserLogin> list = new ArrayList<UserLogin>();
		String sql = "select userID, userName, roleName from userlogin, role where userlogin.role = role.roleID";
		ResultSet rs = conn.find(sql);
		try {
			while(rs.next()) {
				int userId = rs.getInt("userID");
				String userName = rs.getString("userName");
				String password = rs.getString("password");
				int role = rs.getInt("role");
				userLogin = new UserLogin(userId, userName, password, role);
				list.add(userLogin);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	// 查看单个用户
	public List<UserLogin> findOne(int userId) {
		List<UserLogin> list = new ArrayList<UserLogin>();
		String sql = "select * from userlogin where userID = " + userId;
		ResultSet rs = conn.find(sql);
		try {
			while(rs.next()) {
				int userID = rs.getInt("userID");
				String userName = rs.getString("userName");
				String password = rs.getString("password");
				int role = rs.getInt("role");
				userLogin = new UserLogin(userID, userName, password, role);
				list.add(userLogin);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
}
