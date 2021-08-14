package com.example.demo.Security;

import java.util.Set;

import com.google.common.collect.Sets;
import static com.example.demo.Security.UserPermission.*;

public enum UserRole {
	USER(Sets.newHashSet()),
	ADMIN(Sets.newHashSet(ADMIN_WRITE,ADMIN_UPDATE,ADMIN_READ,ADMIN_DELETE)),
	COLLAB(Sets.newHashSet(ADMIN_READ));
	private final Set<UserPermission> permission;

	private UserRole(Set<UserPermission> permission) {
		this.permission = permission;
	}

	public Set<UserPermission> getPermission() {
		return permission;
	}
	
}
