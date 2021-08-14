package com.example.demo.Security;

public enum UserPermission {
	ADMIN_READ("admin:read"),
	ADMIN_WRITE("admin:write"),
	ADMIN_UPDATE("admin:update"),
	ADMIN_DELETE("admin:delete");
	private final String permission;
	UserPermission(String permission) {
		this.permission = permission;
	}

	public String getPermission() {
		return permission;
	}
	
}
