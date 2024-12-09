package ru.jiraproject.jira.service;

import ru.jiraproject.jira.model.dto.userDto.UserDto;
import ru.jiraproject.jira.model.dto.userDto.UserResponce;

public interface UserService {

    UserResponce getUser(Long userId);
    UserResponce postUser(UserDto userDto);
    UserResponce patchUser(UserDto userDto);
    String deleteUser(Long userId);
}
