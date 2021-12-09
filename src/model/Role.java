package model;

public class Role {
	private int roleId;
	private String roleName;
	private String permission;
	
	public Role() { super(); }
	
	public Role(int roleId, String roleName, String permission) {
		super();
		this.roleId = roleId;
		this.roleName = roleName;
		this.permission = permission;
	}
	
	public int getRoleId() { return this.roleId; }
	public void setRoleId(int roleId) { this.roleId = roleId; }
	
	public String getRoleName() { return this.roleName; }
	public void setRoleName(String roleName) { this.roleName = roleName; }
	
	public String getPermission() { return this.permission; }
	public void setPermission(String permission) { this.permission = permission; }
}
