package com.Architecture_Website.Architecture_Website.Request;

public record AccountRegisterRequest(
        String username,
        String password,
        String email
) {
}
