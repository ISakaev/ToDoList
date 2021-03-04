package com.isakaev.todolist.model;

import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

/**
 * Enum Role
 */
public enum Role {
    USER(Set.of(Permission.DEVELOPERS_READ)),
    ADMIN(Set.of(Permission.DEVELOPERS_READ, Permission.DEVELOPERS_WRITE));

    private final Set<Permission> permissions;

    Role(Set<Permission> developersRead) {
        this.permissions = developersRead;
    }

    public Set<Permission> getPermissions() {
        return permissions;
    }

    public Set<SimpleGrantedAuthority> getAuthority() {
        return getPermissions().stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toSet());
    }
}
