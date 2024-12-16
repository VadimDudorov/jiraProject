package ru.jiraproject.jira.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.jiraproject.jira.enums.Response;
import ru.jiraproject.jira.model.dto.userDto.UserDto;
import ru.jiraproject.jira.model.dto.userDto.UserResponse;
import ru.jiraproject.jira.model.entity.UserEntity;
import ru.jiraproject.jira.model.mapper.UserMapper;
import ru.jiraproject.jira.repository.jira.UserRepository;
import ru.jiraproject.jira.service.UserService;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public UserResponse getUser(Long userId) {
        Optional<UserEntity> byId = userRepository.findById(userId);
        if(byId.isEmpty()){
            throw new RuntimeException("По указанному userId не найден пользователь");
        }
        UserResponse userResponse = userMapper.createUserResponse(byId.get());
        return userResponse;
    }

    @Override
    public UserResponse postUser(UserDto userDto) {
        UserEntity save = userRepository.save(userMapper.createUser(userDto));
        return userMapper.createUserResponse(save);
    }

    @Override
    public String patchUser(UserDto userDto) {
        if(userDto.userId() == null){
            throw new RuntimeException("userId отсутствует");
        }
        userRepository.save(userMapper.createUser(userDto));
        return Response.OK.getDescription();
    }

    @Override
    public String deleteUser(Long userId) {
        userRepository.deleteById(userId);
        return Response.OK.getDescription();
    }
}
