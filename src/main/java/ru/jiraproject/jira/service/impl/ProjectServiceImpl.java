package ru.jiraproject.jira.service.impl;

import lombok.RequiredArgsConstructor;
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

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ProjectServiceImpl implements ProjectService {

  private final ProjectRepository projectRepository;
  private final ProjectMapper projectMapper;

  @Override
  public ServiceResponse getProject(Long projectId) {

    Optional<ProjectEntity> projectEntity = projectRepository.findById(projectId);

    ProjectResponse projectResponse = projectMapper.createProjectResponse(
        projectEntity.orElseThrow(
            () -> new JiraNotFoundException("Указанный projectId отсутствует")));

    return ServiceResponse.builder().status(ResponseOK.statusResponseOK()).object(projectResponse)
        .build();
  }

  @Override
  public ServiceResponse postProject(ProjectDto projectDto) {

    ProjectEntity saveProject = projectRepository.save(projectMapper.createProject(projectDto));

    return ServiceResponse.builder().status(ResponseOK.statusResponseOK()).object(saveProject)
        .build();
  }

  @Override
  public ServiceResponse patchProject(ProjectDto projectDto) {

    if (projectDto.projectId() == null) {
      throw new JiraNotFoundException("projectId отсутствует");
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
