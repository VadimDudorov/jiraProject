package ru.jiraproject.jira.model.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import ru.jiraproject.jira.model.dto.taskDto.TaskDto;
import ru.jiraproject.jira.model.dto.taskDto.TaskResponse;
import ru.jiraproject.jira.model.entity.TaskEntity;

@Mapper(componentModel = "spring")
public interface TaskMapper {
    TaskEntity createTask(TaskDto taskDto);

    TaskDto createTaskDto(TaskEntity task);

    @Mappings(value = {
            @Mapping(target = "userId", source = "task.user.userId"),
            @Mapping(target = "projectId", source = "task.project.projectId")
    })
    TaskResponse createTaskResponse(TaskEntity task);
}
