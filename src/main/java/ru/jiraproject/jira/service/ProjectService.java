package ru.jiraproject.jira.service;

import ru.jiraproject.jira.model.dto.projectDto.ProjectDto;
import ru.jiraproject.jira.model.dto.projectDto.ProjectResponce;

public interface ProjectService {

    ProjectResponce getProject(Long taskId);
    ProjectResponce postProject(ProjectDto projectDto);
    ProjectResponce patchProject(ProjectDto projectDto);
    String deleteProject(Long projectId);
}
