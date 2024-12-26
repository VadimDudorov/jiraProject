package ru.jiraproject.jira.service;

import ru.jiraproject.jira.model.dto.projectDto.ProjectDto;
import ru.jiraproject.jira.model.dto.projectDto.ProjectResponse;
import ru.jiraproject.jira.model.response.ServiceResponse;

public interface ProjectService {

  ServiceResponse getProject(Long projectId);

  ServiceResponse postProject(ProjectDto projectDto);

  ServiceResponse patchProject(ProjectDto projectDto);

  ServiceResponse deleteProject(Long projectId);
}
