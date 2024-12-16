package ru.jiraproject.jira.model.mapper;

import org.mapstruct.Mapper;
import ru.jiraproject.jira.model.dto.projectDto.ProjectDto;
import ru.jiraproject.jira.model.dto.projectDto.ProjectResponse;
import ru.jiraproject.jira.model.entity.ProjectEntity;

@Mapper(componentModel = "spring")
public interface ProjectMapper {
    ProjectEntity createProject(ProjectDto projectDto);
    ProjectDto createProjectDto(ProjectEntity project);
    ProjectResponse createProjectResponse(ProjectEntity project);
}
