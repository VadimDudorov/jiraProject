package ru.jiraproject.jira.api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.jiraproject.jira.model.dto.taskDto.TaskDto;
import ru.jiraproject.jira.model.dto.taskDto.TaskResponce;
import ru.jiraproject.jira.service.TaskService;

@RestController
@RequestMapping({"/api/v1.0"})
@RequiredArgsConstructor
public class TaskController {
    private final TaskService taskService;

    @GetMapping("/task")
    public TaskResponce getTask(Long taskId){
        return taskService.getTask(taskId);
    }

    @PostMapping("/task")
    public TaskResponce postTask(@RequestBody TaskDto taskDto) {
        return taskService.postTask(taskDto);
    }

    @PatchMapping("/task")
    public TaskResponce patchTask(@RequestBody TaskDto taskDto) {
        return taskService.patchTask(taskDto);
    }

    @DeleteMapping("/task")
    public String deleteTask(Long taskId) {
        return taskService.deleteTask(taskId);
    }
}
