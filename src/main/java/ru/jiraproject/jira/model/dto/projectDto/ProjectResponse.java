package ru.jiraproject.jira.model.dto.projectDto;

import ru.jiraproject.jira.model.dto.taskDto.TaskResponse;

import java.util.List;

public record ProjectResponse(Long projectId, List<TaskResponse> tasks) {
}
