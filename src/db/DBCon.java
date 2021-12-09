package db;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;


public class DBCon {
	Connection con = null;
	Statement st = null;
	ResultSet rs = null;
	String driver=null;
	String url = null;
	String username = null;
	String password = null;
	

	public Connection dbCon() {
		driver="com.mysql.cj.jdbc.Driver";
				url="jdbc:mysql://localhost:3306/zy?useUnicode=true&characterEncoding=utf8&useSSL=false&serverTimezone=UTC";
				username="root";
				password="Kyrie3032";
			/*Class.forName("com.mysql.jdbc.Driver");
			url=jdbc:mysql://localhost:3306/zy?useUnicode=true&characterEncoding=utf8&useSSL=true;
			username = "root";
			password = "root";*/
			try {
				Class.forName(driver);
				con = DriverManager.getConnection(url, username, password);
			} catch (SQLException e) {

				e.printStackTrace();
			}
		 catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return con;
	}

	/*
	 * 增删改
	 */
	public int query(String sql) {
		int rs = 0;
		con = dbCon();
		try {
			st = con.createStatement();
			rs = st.executeUpdate(sql);
		} catch (SQLException e) {
			close();
			e.printStackTrace();
		}

		return rs;
	}

	/*
	 * 查
	 */
	public ResultSet find(String sql) {

		try {
			con = dbCon();
			st = con.createStatement();
			rs = st.executeQuery(sql);
		} catch (SQLException e) {
			close();
			e.printStackTrace();
		}
		return rs;
	}

	/*
	 * 关闭数据库
	 */
	public void close() {
		try {
			if (rs != null)
				rs.close();
			if (st != null)
				st.close();
			if (con != null)
				con.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}
}
