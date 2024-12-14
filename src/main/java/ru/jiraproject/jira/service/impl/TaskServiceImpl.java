package ru.jiraproject.jira.service.impl;

import org.springframework.stereotype.Service;
import ru.jiraproject.jira.model.dto.taskDto.TaskDto;
import ru.jiraproject.jira.model.dto.taskDto.TaskResponse;
import ru.jiraproject.jira.service.TaskService;

@Service
public class TaskServiceImpl implements TaskService {
    //TODO реализовать логику

    @Override
    public TaskResponse getTask(Long taskId) {
        return null;
    }

    @Override
    public TaskResponse postTask(TaskDto taskDto) {
        return null;
    }

    @Override
    public TaskResponse patchTask(TaskDto taskDto) {
        return null;
    }

    @Override
    public String deleteTask(Long taskId) {
        return "";
    }
}
