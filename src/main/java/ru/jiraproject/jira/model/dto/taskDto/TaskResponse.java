package ru.jiraproject.jira.model.dto.taskDto;

import ru.jiraproject.jira.enums.Status;

public record TaskResponse(Long taskId, Long storyPoint, String description, Status status, Long userId, Long projectId) {
}
