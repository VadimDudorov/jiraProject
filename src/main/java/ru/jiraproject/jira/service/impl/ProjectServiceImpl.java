package ru.jiraproject.jira.service.impl;

import org.springframework.stereotype.Service;
import ru.jiraproject.jira.model.dto.projectDto.ProjectDto;
import ru.jiraproject.jira.model.dto.projectDto.ProjectResponce;
import ru.jiraproject.jira.service.ProjectService;

@Service
public class ProjectServiceImpl implements ProjectService {
    //TODO реализовать логику
    @Override
    public ProjectResponce getProject(Long taskId) {
        return null;
    }

    @Override
    public ProjectResponce postProject(ProjectDto projectDto) {
        return null;
    }

    @Override
    public ProjectResponce patchProject(ProjectDto projectDto) {
        return null;
    }

    @Override
    public String deleteProject(Long projectId) {
        return "";
    }
}
