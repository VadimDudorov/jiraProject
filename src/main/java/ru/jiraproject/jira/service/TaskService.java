package ru.jiraproject.jira.service;

import ru.jiraproject.jira.model.dto.taskDto.TaskDto;
import ru.jiraproject.jira.model.dto.taskDto.TaskResponse;

public interface TaskService {

    TaskResponse getTask(Long taskId);
    TaskResponse postTask(TaskDto taskDto);
    TaskResponse patchTask(TaskDto taskDto);
    String deleteTask(Long taskId);
}
