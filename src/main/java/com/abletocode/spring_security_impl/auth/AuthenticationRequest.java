package com.abletocode.spring_security_impl.auth;

public record AuthenticationRequest(
        String username,
        String password
) {
}
