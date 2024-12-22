package ru.jiraproject.jira.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
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

    @Override
    @Cacheable(value = "task", key = "#taskId")
    public TaskResponse getTask(Long taskId) {
        Optional<TaskEntity> byId = taskRepository.findById(taskId);
        if (byId.isEmpty()) {
            throw new JiraNotFoundException("Данный taskId отсутствует в БД", HttpStatus.NOT_FOUND);
        }
        TaskResponse taskResponse = taskMapper.createTaskResponse(byId.get());
        return taskResponse;
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
                throw new JiraNotFoundException("Указанный userId отсутствует", HttpStatus.NOT_FOUND);
            }
        }
        if (taskDto.projectId() != null) {
            Optional<TaskEntity> byId = taskRepository.findById(taskDto.projectId());
            if (byId.isEmpty()) {
                throw new JiraNotFoundException("Указанный projectId отсутствует", HttpStatus.NOT_FOUND);
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
}
