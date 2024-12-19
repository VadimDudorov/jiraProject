package ru.jiraproject.jira.api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.jiraproject.jira.model.dto.taskDto.TaskDto;
import ru.jiraproject.jira.model.dto.taskDto.TaskResponse;
import ru.jiraproject.jira.model.response.ServiceResponse;
import ru.jiraproject.jira.service.TaskService;

@RestController
@RequestMapping({"/api/v1.0"})
@RequiredArgsConstructor
public class TaskController {
    private final TaskService taskService;

    @GetMapping("/tasks/{taskId}")
    public TaskResponse getTask(@PathVariable Long taskId){
        return taskService.getTask(taskId);
    }

    @PostMapping("/tasks")
    public TaskResponse postTask(@RequestBody TaskDto taskDto) {
        taskService.postTask(taskDto);
        return null;
    }

    @PatchMapping("/tasks")
    public ServiceResponse patchTask(@RequestBody TaskDto taskDto) {
        return taskService.patchTask(taskDto);
    }

    @DeleteMapping("/tasks/{userId}")
    public ServiceResponse deleteTask(@PathVariable Long taskId) {
        return taskService.deleteTask(taskId);
    }
}
