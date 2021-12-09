package model;

import com.sun.org.apache.bcel.internal.generic.RETURN;

public class UserLogin {
	private int userId;
	private String userName;
	private String password;
	private int role;
	
	public UserLogin() { super(); }
	
	public UserLogin(int userId, String userName, String password, int role) {
		super();
		this.userId = userId;
		this.userName = userName;
		this.password = password;
		this.role = role;
	}
	public UserLogin(int userId, String password, int role) {
		super();
		this.userId = userId;
		this.password = password;
		this.role = role;
	}
	public UserLogin(String userName, String password, int role) {
		super();
		this.userName = userName;
		this.password = password;
		this.role = role;
	}
	
	
	public int getUserId() { return this.userId; }
	public void setUserId(int userId) { this.userId = userId; }
	public void setUserId(String userId) { this.userId = Integer.valueOf("userId"); }
	
	public String getUserName() { return userName; }
	public void setUserName(String userName) { this.userName = userName; }
	
	public String getPassword() { return password; }
	public void setPassword(String password) { this.password = password; }
	
	public int getRole() { return role; }
	public String trans() { 
		if (role==2) return "学生";
		else if(role ==1) return "教师";
		else return "教务员";
		}
	public void setRole(int role) { this.role = role; }
}