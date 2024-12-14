package ru.jiraproject.jira.service;

import ru.jiraproject.jira.model.dto.userDto.UserDto;
import ru.jiraproject.jira.model.dto.userDto.UserResponse;

public interface UserService {

    UserResponse getUser(Long userId);
    UserResponse postUser(UserDto userDto);
    UserResponse patchUser(UserDto userDto);
    String deleteUser(Long userId);
}
