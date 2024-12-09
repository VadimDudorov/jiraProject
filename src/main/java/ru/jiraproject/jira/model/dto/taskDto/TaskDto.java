package ru.jiraproject.jira.model.dto.taskDto;

import ru.jiraproject.jira.enums.Status;
import ru.jiraproject.jira.model.entity.Project;
import ru.jiraproject.jira.model.entity.User;

public record TaskDto(Long taskId, String description, Status status, User user, Project project) {
}
