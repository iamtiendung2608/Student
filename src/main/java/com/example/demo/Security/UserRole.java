package com.example.demo.Security;

import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

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
	public Set<SimpleGrantedAuthority>getGrandtedAuthorities(){
		Set<SimpleGrantedAuthority>permissions = getPermission().stream()
				.map(permission  -> new SimpleGrantedAuthority(permission.getPermission()))
				.collect(Collectors.toSet());
		permissions.add(new SimpleGrantedAuthority("ROLE_"+this.name()));
		return permissions;
	}
}
