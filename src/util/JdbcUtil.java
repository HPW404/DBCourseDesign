package util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.Properties;
 
//  �������ݿ�
public class JdbcUtil {
	
	private static Properties p = new Properties();
	static Connection conn = null;
	static Statement st = null;
	static ResultSet rs = null;

	// ���ش����õ�Connection����,�þ�̬�����ַ�ʽӦ�ðѹ�����˽�л�����
	public static Connection getConn() {
		try {
			ClassLoader loader = Thread.currentThread().getContextClassLoader();
			InputStream inStream = loader.getResourceAsStream("db.properties");
			p.load(inStream); // ����
		} catch (IOException e) {
			throw new RuntimeException("����classpath·���µ�db.properties�ļ�ʧ��", e);
		}
		// 1����ע������
		try {
			Class.forName(p.getProperty("DriverName"));
			System.out.println("����������������");
		} catch (Exception e) {
			throw new RuntimeException("���ݿ���������ʧ��", e);
		}
		try {
			System.out.println("�������ݿ�����");
			// 2��ȡ���Ӷ���
			return DriverManager.getConnection(p.getProperty("url"), p.getProperty("username"),
					p.getProperty("password"));
		} catch (Exception e) {
			e.printStackTrace();
		}
		throw new RuntimeException("���ݿ������쳣");
	}
	// 5):�ͷ���Դ
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
	
	// ��ɾ��
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
	
	// ��
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