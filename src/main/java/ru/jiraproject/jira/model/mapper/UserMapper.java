package ru.jiraproject.jira.model.mapper;

import org.mapstruct.Mapper;
import ru.jiraproject.jira.model.dto.userDto.UserDto;
import ru.jiraproject.jira.model.dto.userDto.UserResponse;
import ru.jiraproject.jira.model.entity.UserEntity;

@Mapper(componentModel = "spring")
public interface UserMapper {

  UserEntity createUser(UserDto userDto);

  UserDto createUserDto(UserEntity user);

  UserResponse createUserResponse(UserEntity user);
}
