package ru.jiraproject.jira.model.dto.userDto;

import ru.jiraproject.jira.model.entity.TaskEntity;

import java.time.LocalDateTime;
import java.util.List;

public record UserResponse(Long userId, String firstName, String lastName, LocalDateTime birthDate, String role, List<TaskEntity> tasks) {
}
