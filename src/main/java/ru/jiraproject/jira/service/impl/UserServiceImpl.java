package ru.jiraproject.jira.service.impl;

import org.springframework.stereotype.Service;
import ru.jiraproject.jira.model.dto.userDto.UserDto;
import ru.jiraproject.jira.model.dto.userDto.UserResponse;
import ru.jiraproject.jira.service.UserService;

@Service
public class UserServiceImpl implements UserService {
    //TODO реализовать логику

    @Override
    public UserResponse getUser(Long userId) {
        return null;
    }

    @Override
    public UserResponse postUser(UserDto userDto) {
        return null;
    }

    @Override
    public UserResponse patchUser(UserDto userDto) {
        return null;
    }

    @Override
    public String deleteUser(Long userId) {
        return "";
    }
}
