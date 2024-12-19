package ru.jiraproject.jira.model.dto.taskDto;

import ru.jiraproject.jira.enums.Status;

import javax.validation.constraints.NotNull;

public record TaskDto(
        Long taskId,
        @NotNull(message = "description обязателен для заполнения")
        String description,
        @NotNull(message = "status обязателен для заполнения")
        Status status,
        Long userId,
        Long projectId) {
}
