package ru.anikeeva.security.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record UserDTO(
        int id,
        String username,
        @JsonProperty(access = JsonProperty.Access.WRITE_ONLY) String password
) {
}
