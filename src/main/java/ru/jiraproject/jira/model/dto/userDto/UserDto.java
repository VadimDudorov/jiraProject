package ru.jiraproject.jira.model.dto.userDto;

import java.time.LocalDateTime;

public record UserDto(Long userId, String firstName, String lastName, LocalDateTime birthDate,
                      String role) {

}
