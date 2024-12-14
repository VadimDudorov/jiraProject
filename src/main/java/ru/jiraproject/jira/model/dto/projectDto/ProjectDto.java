package ru.jiraproject.jira.model.dto.projectDto;

import ru.jiraproject.jira.model.entity.TaskEntity;

import java.util.List;

public record ProjectDto(Long projectId, String name, List<TaskEntity> tasks) {
}
