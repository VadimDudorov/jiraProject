package ru.jiraproject.jira.service;

import ru.jiraproject.jira.model.dto.taskDto.TaskDto;
import ru.jiraproject.jira.model.response.ServiceResponse;

public interface TaskService {

  ServiceResponse getTask(Long taskId);

  void postTask(TaskDto taskDto);

  ServiceResponse patchTask(TaskDto taskDto);

  ServiceResponse deleteTask(Long taskId);

  void postTaskKafka(String message);
}