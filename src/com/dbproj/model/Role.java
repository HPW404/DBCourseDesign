package com.dbproj.model;

public class Role {
	private int roleId;
	private String roleName;
	private String permission;
	
	public Role() { }
	
	public int getRoleId() { return this.roleId; }
	public void setRoleId(int roleId) { this.roleId = roleId; }
	
	public String getRoleName() { return this.roleName; }
	public void setRoleName(String roleName) { this.roleName = roleName; }
	
	public String getPermission() { return this.permission; }
	public void setPermission(String permission) { this.permission = permission; }
}