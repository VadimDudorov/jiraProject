package ru.jiraproject.jira.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import ru.jiraproject.jira.enums.Response;
import ru.jiraproject.jira.model.dto.taskDto.TaskDto;
import ru.jiraproject.jira.model.dto.taskDto.TaskResponse;
import ru.jiraproject.jira.model.entity.TaskEntity;
import ru.jiraproject.jira.model.mapper.TaskMapper;
import ru.jiraproject.jira.repository.jira.TaskRepository;
import ru.jiraproject.jira.service.TaskService;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class TaskServiceImpl implements TaskService {
    private final TaskRepository taskRepository;
    private final TaskMapper taskMapper;

    @Override
    @Cacheable(value = "task", key = "#taskId")
    public TaskResponse getTask(Long taskId) {
        Optional<TaskEntity> byId = taskRepository.findById(taskId);
        if(byId.isEmpty()){
            throw new RuntimeException("Данный taskId отсутствует в БД");
        }
        TaskResponse taskResponse = taskMapper.createTaskResponse(byId.get());
        return taskResponse;
    }

    @Override
    public String patchTask(TaskDto taskDto) {
        if(taskDto.userId() != null){
            Optional<TaskEntity> byId = taskRepository.findById(taskDto.userId());
            if(byId.isEmpty()){
                throw new RuntimeException("Указанный userId отсутствует");
            }
        }
        if(taskDto.projectId() != null){
            Optional<TaskEntity> byId = taskRepository.findById(taskDto.projectId());
            if(byId.isEmpty()){
                throw new RuntimeException("Указанный projectId отсутствует");
            }
        }
        taskRepository.save(taskMapper.createTask(taskDto));
        return Response.OK.getDescription();
    }

    @Override
    public String deleteTask(Long taskId) {
        taskRepository.deleteById(taskId);
        return Response.OK.getDescription();
    }
}
