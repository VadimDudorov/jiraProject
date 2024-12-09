package ru.jiraproject.jira.api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.jiraproject.jira.model.dto.projectDto.ProjectDto;
import ru.jiraproject.jira.model.dto.projectDto.ProjectResponce;
import ru.jiraproject.jira.service.ProjectService;

@RestController
@RequestMapping({"/api/v1.0"})
@RequiredArgsConstructor
public class ProjectController {
    private final ProjectService projectService;

    @GetMapping("/project")
    public ProjectResponce getProject(@RequestHeader Long projectId){
        return projectService.getProject(projectId);
    }

    @PostMapping("/project")
    public ProjectResponce postProject(@RequestBody ProjectDto projectDto) {
        return projectService.postProject(projectDto);
    }

    @PatchMapping("/project")
    public ProjectResponce patchProject(@RequestBody ProjectDto projectDto) {
        return projectService.patchProject(projectDto);
    }

    @DeleteMapping("/project")
    public String deleteProject(@RequestHeader Long projectId) {
        return projectService.deleteProject(projectId);
    }
}
