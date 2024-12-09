package ru.jiraproject.jira.model.mapper;

import org.mapstruct.Mapper;
import ru.jiraproject.jira.model.dto.projectDto.ProjectDto;
import ru.jiraproject.jira.model.dto.projectDto.ProjectResponce;
import ru.jiraproject.jira.model.entity.Project;

@Mapper(componentModel = "spring")
public interface ProjectMapper {
    Project createProject(ProjectDto projectDto);
    ProjectDto createProjectDto(Project project);
    ProjectResponce createProjectResponce(Project project);
}
