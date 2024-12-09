package ru.jiraproject.jira.model.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import ru.jiraproject.jira.model.dto.taskDto.TaskDto;
import ru.jiraproject.jira.model.dto.taskDto.TaskResponce;
import ru.jiraproject.jira.model.entity.Task;

@Mapper(componentModel = "spring")
public interface TaskMapper {
    Task createTask(TaskDto taskDto);
    TaskDto createTaskDto(Task task);

    @Mappings(value = {
            @Mapping(target = "userId", source = "task.user.userId"),
            @Mapping(target = "projectId", source = "task.project.projectId")
    })
    TaskResponce createTaskResponce(Task task);
}
