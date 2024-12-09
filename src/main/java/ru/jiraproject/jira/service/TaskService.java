package ru.jiraproject.jira.service;

import ru.jiraproject.jira.model.dto.taskDto.TaskDto;
import ru.jiraproject.jira.model.dto.taskDto.TaskResponce;

public interface TaskService {

    TaskResponce getTask(Long taskId);
    TaskResponce postTask(TaskDto taskDto);
    TaskResponce patchTask(TaskDto taskDto);
    String deleteTask(Long taskId);
}
