package ru.jiraproject.jira.model.dto.userDto;

import ru.jiraproject.jira.model.entity.Task;

import java.time.LocalDateTime;
import java.util.List;

public record UserResponce(Long userId, String firstName, String lastName, LocalDateTime birthDate, String role, List<Task> tasks) {
}
