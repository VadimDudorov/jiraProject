package ru.jiraproject.jira.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.jiraproject.jira.exception.JiraBadRequestException;
import ru.jiraproject.jira.exception.JiraNotFoundException;
import ru.jiraproject.jira.model.dto.userDto.UserDto;
import ru.jiraproject.jira.model.dto.userDto.UserResponse;
import ru.jiraproject.jira.model.entity.UserEntity;
import ru.jiraproject.jira.model.mapper.UserMapper;
import ru.jiraproject.jira.model.response.ServiceResponse;
import ru.jiraproject.jira.repository.jira.UserRepository;
import ru.jiraproject.jira.service.UserService;
import ru.jiraproject.jira.util.ResponseOK;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

  private final UserRepository userRepository;
  private final UserMapper userMapper;

  @Override
  public ServiceResponse getUser(Long userId) {

    Optional<UserEntity> userEntity = userRepository.findById(userId);

    UserResponse userResponse = userMapper.createUserResponse(userEntity.orElseThrow(
        () -> new JiraNotFoundException("По указанному userId не найден пользователь")));

    return ServiceResponse.builder().status(ResponseOK.statusResponseOK()).object(userResponse)
        .build();
  }

  @Override
  public ServiceResponse postUser(UserDto userDto) {

    UserEntity userEntity = userRepository.save(userMapper.createUser(userDto));
    UserResponse userResponse = userMapper.createUserResponse(userEntity);

    return ServiceResponse.builder().status(ResponseOK.statusResponseOK()).object(userResponse)
        .build();
  }

  @Override
  public ServiceResponse patchUser(UserDto userDto) {

    if (userDto.userId() == null) {
      throw new JiraBadRequestException("userId отсутствует");
    }

    userRepository.save(userMapper.createUser(userDto));

    return ResponseOK.statusOK();
  }

  @Override
  public ServiceResponse deleteUser(Long userId) {

    userRepository.deleteById(userId);

    return ResponseOK.statusOK();
  }
}
