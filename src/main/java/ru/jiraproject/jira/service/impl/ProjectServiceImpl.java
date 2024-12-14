package ru.jiraproject.jira.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.jiraproject.jira.model.dto.projectDto.ProjectDto;
import ru.jiraproject.jira.model.dto.projectDto.ProjectResponse;
import ru.jiraproject.jira.model.entity.ProjectEntity;
import ru.jiraproject.jira.model.mapper.ProjectMapper;
import ru.jiraproject.jira.repository.jira.ProjectRepository;
import ru.jiraproject.jira.service.ProjectService;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {
    private final ProjectRepository projectRepository;
    private final ProjectMapper projectMapper;

    @Override
    public ProjectResponse getProject(Long projectId) {
        Optional<ProjectEntity> byId = projectRepository.findById(projectId);
        ProjectResponse projectResponse = projectMapper.createProjectResponse(byId.get());
        return projectResponse;
    }

    @Override
    public ProjectResponse postProject(ProjectDto projectDto) {
        return null;
    }

    @Override
    public ProjectResponse patchProject(ProjectDto projectDto) {
        return null;
    }

    @Override
    public String deleteProject(Long projectId) {
        return "";
    }
}
