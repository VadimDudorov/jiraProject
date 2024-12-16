package ru.jiraproject.jira.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.jiraproject.jira.enums.Response;
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
        ProjectEntity saveProject = projectRepository.save(projectMapper.createProject(projectDto));
        return projectMapper.createProjectResponse(saveProject);
    }

    @Override
    public String patchProject(ProjectDto projectDto) {
        if (projectDto.projectId() == null) {
            throw new RuntimeException("projectId отсутствует");
        }
        projectRepository.save(projectMapper.createProject(projectDto));
        return Response.OK.getDescription();
    }

    @Override
    public String deleteProject(Long projectId) {
        projectRepository.deleteById(projectId);
        return Response.OK.getDescription();
    }
}
