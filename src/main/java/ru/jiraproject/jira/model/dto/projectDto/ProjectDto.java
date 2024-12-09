package ru.jiraproject.jira.model.dto.projectDto;

import ru.jiraproject.jira.model.entity.Task;

import java.util.List;

public record ProjectDto(Long projectId, String nameProject, List<Task> tasks) {
}
