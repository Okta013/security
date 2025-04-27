package ru.anikeeva.security.dto;

public record UserLoginRequest(
    String username,
    String password
)
{}