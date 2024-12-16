package ru.jiraproject.jira.model.dto.userDto;

import ru.jiraproject.jira.model.dto.taskDto.TaskResponse;

import java.time.LocalDateTime;
import java.util.List;

public record UserResponse(Long userId, String firstName, String lastName, LocalDateTime birthDate, String role, List<TaskResponse> tasks) {
}
