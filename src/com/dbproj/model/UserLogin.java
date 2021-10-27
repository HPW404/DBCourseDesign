package com.dbproj.model;

public class UserLogin {
	private int userId;
	private String userName;
	private String password;
	private int role;
	
	public int getUserId() { return this.userId; }
	public void setUserId(int userId) { this.userId = userId; }
	
	public String getUserName() { return this.userName; }
	public void setUserName(String userName) { this.userName = userName; }
	
	public String getPassword() { return this.password; }
	public void setPassword(String password) { this.password = password; }
	
	public int getRole() { return this.role; }
	public void setRole(int role) { this.role = role; }
}