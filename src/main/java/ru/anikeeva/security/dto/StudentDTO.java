package ru.anikeeva.security.dto;

import com.fasterxml.jackson.annotation.JsonProperty;

public record StudentDTO(
        @JsonProperty(access = JsonProperty.Access.READ_ONLY) int id,
        String name,
        int marks
)
{}