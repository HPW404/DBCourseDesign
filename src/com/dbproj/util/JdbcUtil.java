package com.dbproj.util;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
 
//  �������ݿ�
public class JdbcUtil {
	private static Properties p = new Properties();
	static {
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
	}
	// ���ش����õ�Connection����,�þ�̬�����ַ�ʽӦ�ðѹ�����˽�л�����
	public static Connection getConn() {
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
	// ��ֹ�ȴ�������Ȼ���ٵ��÷�����������紴����ֱ������������
	private JdbcUtil() {
		}
 
}