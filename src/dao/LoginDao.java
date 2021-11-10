package dao;

import java.sql.*;

import model.UserLogin;
import util.JdbcUtil;

public class LoginDao {
	UserLogin user;
	private String sql = "";
	public UserLogin login(String userId, String password) {
		sql = "SELECT * FROM userLogin WHERE userId = ? AND password = ?";
		Connection connection = null;
		PreparedStatement pStatement = null;
		ResultSet rSet = null;
		try {
			try {
				connection = JdbcUtil.getConn();
			} catch(Exception e) {
				e.printStackTrace();
			}
			pStatement = (PreparedStatement)connection.prepareStatement(sql);
			pStatement.setString(1, userId);
			pStatement.setString(2, password);
			rSet = (ResultSet)pStatement.executeQuery();
			if(rSet.next()) {
				user = new UserLogin();
				user.setUserId(rSet.getString("userId"));
				user.setPassword(rSet.getString("password"));
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return user;
	}
}
