package dao;

import java.sql.*;

import model.UserLogin;
import util.JdbcUtil;

public class RegisterDao {
	UserLogin userLogin;
	private String sql = "";
	public UserLogin register(int userId, String userName, String password, int role) {
		sql = "INSERT INTO userlogin VALUES(?,?,?,?)";
		Connection connection = null;
		PreparedStatement pStatement = null;
		try {
			connection = JdbcUtil.getConn();
			pStatement = (PreparedStatement) connection.prepareStatement(sql);
			
			pStatement.setInt(1, userId);
			pStatement.setString(2, userName);
			pStatement.setString(3, password);
			pStatement.setInt(4, role);
			
			pStatement.execute();
			connection.close();
			pStatement.close();
		} catch(Exception e) {
			e.printStackTrace();
		} finally {
			JdbcUtil.close(connection);
		}
		return userLogin;
	}
}
