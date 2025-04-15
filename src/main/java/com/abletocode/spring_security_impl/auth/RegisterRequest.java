package com.abletocode.spring_security_impl.auth;

import com.abletocode.spring_security_impl.user.Role;

public record RegisterRequest(
        String firstName,
        String lastName,
        String username,
        String password,
        Role role
) {
}
