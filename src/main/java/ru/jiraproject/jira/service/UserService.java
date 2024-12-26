package ru.jiraproject.jira.service;

import ru.jiraproject.jira.model.dto.userDto.UserDto;
import ru.jiraproject.jira.model.dto.userDto.UserResponse;
import ru.jiraproject.jira.model.response.ServiceResponse;

public interface UserService {

  ServiceResponse getUser(Long userId);

  ServiceResponse postUser(UserDto userDto);

  ServiceResponse patchUser(UserDto userDto);

  ServiceResponse deleteUser(Long userId);
}
