package ru.jiraproject.jira.api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.jiraproject.jira.model.dto.projectDto.ProjectDto;
import ru.jiraproject.jira.model.dto.projectDto.ProjectResponse;
import ru.jiraproject.jira.model.response.ServiceResponse;
import ru.jiraproject.jira.service.ProjectService;

@RestController
@RequestMapping({"/api/v1.0"})
@RequiredArgsConstructor
public class ProjectController {

  private final ProjectService projectService;

  @GetMapping("/projects/{userId}")
  public ServiceResponse getProject(@PathVariable Long projectId) {
    return projectService.getProject(projectId);
  }

  @PostMapping("/projects")
  public ServiceResponse postProject(@RequestBody ProjectDto projectDto) {
    return projectService.postProject(projectDto);
  }

  @PatchMapping("/projects")
  public ServiceResponse patchProject(@RequestBody ProjectDto projectDto) {
    return projectService.patchProject(projectDto);
  }

  @DeleteMapping("/projects/{userId}")
  public ServiceResponse deleteProject(@PathVariable Long projectId) {
    return projectService.deleteProject(projectId);
  }
}
