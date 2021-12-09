package dao.Impl;

import java.sql.*;
import java.util.List;
import java.util.ArrayList;

import model.UserLogin;
import dao.UserDao;
import db.DBCon;


public class UserDaoImpl implements UserDao {
	private DBCon conn = new DBCon();
	private UserLogin userLogin;
	
	// 用户登录
	public UserLogin login(UserLogin user) {
		String sql = "select * from userlogin where userName='"+user.getUserName()+"'";
		ResultSet rs = conn.find(sql);
		try {
			while(rs.next()) {
				int userId = rs.getInt("userID");
				String userName = rs.getString("userName");
				String password = rs.getString("password");
				int role = rs.getInt("role");
				userLogin = new UserLogin(userId, userName, password, role);
				System.out.println(userLogin.getUserId());
				System.out.println(userLogin.getPassword());
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return userLogin;
	}
	
	// 修改密码
	public int editPassword(UserLogin userLogin) {
		String sql = "update userlogin set password = '" + userLogin.getPassword() 
				+ "' where userName = " +"'"+ userLogin.getUserName()+"'";
		int rs = conn.query(sql);
		System.out.println(sql);
		return rs;
	}
		
	// 修改账户信息
	public int editUser(UserLogin userLogin) {
		String sql = "update userlogin set role = '" + userLogin.getRole()
				+ "' where userID = " + "'"+userLogin.getUserId()+"'";
		int rs = conn.query(sql);
		return rs;
	}
	
	// 添加用户
	public int addUser(UserLogin userLogin) {
		String sql = "insert into userlogin(userID, userName, password, role) values("
				+ userLogin.getUserId() 
				+ ", '"
				+ userLogin.getUserName() 
				+ "', '"
				+ userLogin.getPassword() 
				+ "', "
				+ userLogin.getRole() 
				+ ")";
		int rs = conn.query(sql);
		return rs;
	}
	
	// 查看所有用户
	public List<UserLogin> findAll() {
		List<UserLogin> list = new ArrayList<UserLogin>();
		String sql = "select * from userlogin";
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
		} catch (SQLException e) {
			conn.close();
			e.printStackTrace();
		}
		return list;
	}
}
