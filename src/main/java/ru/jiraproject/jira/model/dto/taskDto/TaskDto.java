package ru.jiraproject.jira.model.dto.taskDto;

import ru.jiraproject.jira.enums.Status;
import ru.jiraproject.jira.model.entity.ProjectEntity;
import ru.jiraproject.jira.model.entity.UserEntity;

public record TaskDto(Long taskId, String description, Status status, UserEntity user, ProjectEntity project) {
}
