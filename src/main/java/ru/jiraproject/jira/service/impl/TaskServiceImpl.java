package ru.jiraproject.jira.service.impl;

import org.springframework.stereotype.Service;
import ru.jiraproject.jira.model.dto.taskDto.TaskDto;
import ru.jiraproject.jira.model.dto.taskDto.TaskResponce;
import ru.jiraproject.jira.service.TaskService;

@Service
public class TaskServiceImpl implements TaskService {
    //TODO реализовать логику

    @Override
    public TaskResponce getTask(Long taskId) {
        return null;
    }

    @Override
    public TaskResponce postTask(TaskDto taskDto) {
        return null;
    }

    @Override
    public TaskResponce patchTask(TaskDto taskDto) {
        return null;
    }

    @Override
    public String deleteTask(Long taskId) {
        return "";
    }
}
