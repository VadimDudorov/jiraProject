package ru.jiraproject.jira.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import ru.jiraproject.jira.exception.JiraNotFoundException;
import ru.jiraproject.jira.model.dto.projectDto.ProjectDto;
import ru.jiraproject.jira.model.dto.projectDto.ProjectResponse;
import ru.jiraproject.jira.model.entity.ProjectEntity;
import ru.jiraproject.jira.model.mapper.ProjectMapper;
import ru.jiraproject.jira.model.response.ServiceResponse;
import ru.jiraproject.jira.repository.jira.ProjectRepository;
import ru.jiraproject.jira.service.ProjectService;
import ru.jiraproject.jira.util.ResponseOK;

import static org.springframework.http.HttpStatus.NOT_FOUND;

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
        ProjectEntity saveProject = projectRepository.save(projectMapper.createProject(projectDto));
        return projectMapper.createProjectResponse(saveProject);
    }

    @Override
    public ServiceResponse patchProject(ProjectDto projectDto) {
        if (projectDto.projectId() == null) {
            throw new JiraNotFoundException("projectId отсутствует", HttpStatus.NOT_FOUND);
        }
        projectRepository.save(projectMapper.createProject(projectDto));
        return ResponseOK.statusOK();
    }

    @Override
    public ServiceResponse deleteProject(Long projectId) {
        projectRepository.deleteById(projectId);
        return ResponseOK.statusOK();
    }
}
