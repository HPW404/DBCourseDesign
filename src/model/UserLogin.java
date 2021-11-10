package model;

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
	
	public int getUserId() { return this.userId; }
	public void setUserId(int userId) { this.userId = userId; }
	public void setUserId(String userId) { this.userId = Integer.valueOf("userId"); }
	
	public String getUserName() { return this.userName; }
	public void setUserName(String userName) { this.userName = userName; }
	
	public String getPassword() { return this.password; }
	public void setPassword(String password) { this.password = password; }
	
	public int getRole() { return this.role; }
	public void setRole(int role) { this.role = role; }
}