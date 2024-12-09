package ru.jiraproject.jira.model.mapper;

import org.mapstruct.Mapper;
import ru.jiraproject.jira.model.dto.userDto.UserDto;
import ru.jiraproject.jira.model.dto.userDto.UserResponce;
import ru.jiraproject.jira.model.entity.User;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User createUser(UserDto userDto);
    UserDto createUserDto(User user);
    UserResponce createUserResponce(User user);
}
