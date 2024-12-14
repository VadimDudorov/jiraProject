package ru.jiraproject.jira.service;

import ru.jiraproject.jira.model.dto.projectDto.ProjectDto;
import ru.jiraproject.jira.model.dto.projectDto.ProjectResponse;

public interface ProjectService {

    ProjectResponse getProject(Long projectId);
    ProjectResponse postProject(ProjectDto projectDto);
    ProjectResponse patchProject(ProjectDto projectDto);
    String deleteProject(Long projectId);
}
