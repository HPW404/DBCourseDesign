package util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.Properties;
 
//  连接数据库
public class JdbcUtil {
	
	private static Properties p = new Properties();
	static Connection conn = null;
	static Statement st = null;
	static ResultSet rs = null;

	// 返回创建好的Connection对象,用静态的这种方式应该把构造器私有化起来
	public static Connection getConn() {
		try {
			ClassLoader loader = Thread.currentThread().getContextClassLoader();
			InputStream inStream = loader.getResourceAsStream("db.properties");
			p.load(inStream); // 加载
		} catch (IOException e) {
			throw new RuntimeException("加载classpath路径下的db.properties文件失败", e);
		}
		// 1加载注册驱动
		try {
			Class.forName(p.getProperty("DriverName"));
			System.out.println("加载数据驱动正常");
		} catch (Exception e) {
			throw new RuntimeException("数据库驱动加载失败", e);
		}
		try {
			System.out.println("连接数据库正常");
			// 2获取连接对象
			return DriverManager.getConnection(p.getProperty("url"), p.getProperty("username"),
					p.getProperty("password"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		throw new RuntimeException("数据库连接异常");
	}
	// 5):释放资源
	public static void close(Connection conn, Statement st, ResultSet re) {
		try {
			if (re != null) {
				re.close();
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if (st != null) {
					st.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
			try {
				if (conn != null) {
					conn.close();
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	public static void close(Connection conn) {
		if(conn != null) {
			try {
				conn.close();
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	public void close() {
		try {
			if (rs != null)
				rs.close();
			if (st != null)
				st.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	// 增删改
	public int query(String sql) {
		int rs = 0;
		conn = getConn();
		try {
			st = conn.createStatement();
			rs = st.executeUpdate(sql);
		} catch (Exception e) {
			close();
			e.printStackTrace();
		}
		return rs;
	}
	
	// 查
	public ResultSet find(String sql) {
		try {
			conn = getConn();
			st = conn.createStatement();
			rs = st.executeQuery(sql);
		} catch (SQLException e) {
			close();
			e.printStackTrace();
		}
		return rs;
	}
 
}