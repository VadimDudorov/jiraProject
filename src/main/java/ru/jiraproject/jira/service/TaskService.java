package ru.jiraproject.jira.service;

import ru.jiraproject.jira.model.dto.taskDto.TaskDto;
import ru.jiraproject.jira.model.dto.taskDto.TaskResponse;
import ru.jiraproject.jira.model.response.ServiceResponse;

public interface TaskService {

    TaskResponse getTask(Long taskId);
    void postTask(TaskDto taskDto);
    ServiceResponse patchTask(TaskDto taskDto);
    ServiceResponse deleteTask(Long taskId);
}
