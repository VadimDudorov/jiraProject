package ru.jiraproject.jira.service.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import ru.jiraproject.jira.exception.JiraNotFoundException;
import ru.jiraproject.jira.feign.KafkaJiraApiFeignClient;
import ru.jiraproject.jira.model.dto.taskDto.TaskDto;
import ru.jiraproject.jira.model.dto.taskDto.TaskResponse;
import ru.jiraproject.jira.model.entity.TaskEntity;
import ru.jiraproject.jira.model.mapper.TaskMapper;
import ru.jiraproject.jira.model.response.ServiceResponse;
import ru.jiraproject.jira.repository.jira.TaskRepository;
import ru.jiraproject.jira.service.TaskService;
import ru.jiraproject.jira.util.ResponseOK;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {

  private final TaskRepository taskRepository;
  private final TaskMapper taskMapper;
  private final KafkaJiraApiFeignClient kafkaJiraApiFeignClient;
  private final ObjectMapper objectMapper;

  @Override
  @Cacheable(value = "task", key = "#taskId")
  public ServiceResponse getTask(Long taskId) {

    Optional<TaskEntity> taskEntity = taskRepository.findById(taskId);

    TaskResponse taskResponse = taskMapper.createTaskResponse(
        taskEntity.orElseThrow(() -> new JiraNotFoundException("Данный taskId отсутствует в БД")));

    return ServiceResponse.builder().status(ResponseOK.statusResponseOK()).object(taskResponse)
        .build();
  }

  @Override
  public void postTask(TaskDto taskDto) {
    kafkaJiraApiFeignClient.postTaskJira(taskDto);
  }

  @Override
  public ServiceResponse patchTask(TaskDto taskDto) {

    if (taskDto.userId() != null) {
      Optional<TaskEntity> byId = taskRepository.findById(taskDto.userId());
      if (byId.isEmpty()) {
        throw new JiraNotFoundException("Указанный userId отсутствует");
      }
    }

    if (taskDto.projectId() != null) {
      Optional<TaskEntity> byId = taskRepository.findById(taskDto.projectId());
      if (byId.isEmpty()) {
        throw new JiraNotFoundException("Указанный projectId отсутствует");
      }
    }

    taskRepository.save(taskMapper.createTask(taskDto));

    return ResponseOK.statusOK();
  }

  @Override
  public ServiceResponse deleteTask(Long taskId) {

    taskRepository.deleteById(taskId);

    return ResponseOK.statusOK();
  }

  public void postTaskKafka(String message) {

    TaskDto taskDto;
    try {
      taskDto = objectMapper.readValue(message, TaskDto.class);
    } catch (Exception e) {
      throw new RuntimeException(e.getMessage());
    }

    taskRepository.save(taskMapper.createTask(taskDto));
  }
}
