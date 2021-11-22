package dao.impl;

import java.sql.*;
import java.util.ArrayList;

import util.JdbcUtil;
import model.UserLogin;
import model.PageBean;

public class EmpBiz {
	JdbcUtil conn = new JdbcUtil();
	UserLogin userLogin;
	PageBean pageBean;
	
	public EmpBiz() { super(); }
	
	// ����ʵ�ַ�ҳ�ķ�������������������һ���ڼ�ҳ��һ��ÿҳ������
	public PageBean listEmps(int pageNo, int pageCount) {
		ResultSet rs = null;
		ArrayList<UserLogin> list = new ArrayList<UserLogin>();
		String sqlCount = "select count(*) from userlogin";
		String sql = "select userID, userName, password, role, roleName from userlogin, role" 
				+ " where userlogin.role=role.roleID " 
				+ "limit " 
				+ ((pageNo - 1) * pageCount) 
				+ "," 
				+ pageCount;
		rs = conn.find(sql);
		try {
			while(rs.next()){
				int userID = rs.getInt("userID");
				String userName = rs.getString("userName");
				String password = rs.getString("password");
				int role = rs.getInt("role");
				userLogin = new UserLogin(userID, userName, password, role);
				list.add(userLogin);
			}
			rs = conn.find(sqlCount);
			int totalCount = 0;
			while(rs.next()){
				totalCount =rs.getInt(1);
			}
			pageBean = new PageBean(list, totalCount, pageNo, pageCount);
			return pageBean;
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return pageBean;
	}
}
