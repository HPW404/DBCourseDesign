package com.dbproj.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
 
//  连接数据库
public class JdbcUtil {
	private static Properties p = new Properties();
	static {
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
	}
	// 返回创建好的Connection对象,用静态的这种方式应该把构造器私有化起来
	public static Connection getConn() {
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
	// 防止先创建对象，然后再调用方法。不让外界创建，直接用类名调用
	private JdbcUtil() {
		}
 
}