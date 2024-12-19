package ru.jiraproject.jira.api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.jiraproject.jira.model.dto.userDto.UserDto;
import ru.jiraproject.jira.model.dto.userDto.UserResponse;
import ru.jiraproject.jira.model.response.ServiceResponse;
import ru.jiraproject.jira.service.UserService;

@RestController
@RequestMapping({"/api/v1.0"})
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/users/{userId}")
    public UserResponse getUser(@PathVariable Long userId){
        return userService.getUser(userId);
    }

    @PostMapping("/users")
    public UserResponse postUser(@RequestBody UserDto userDto) {
        return userService.postUser(userDto);
    }

    @PatchMapping("/users")
    public ServiceResponse patchUser(@RequestBody UserDto userDto) {
        return userService.patchUser(userDto);
    }

    @DeleteMapping("/users/{userId}")
    public ServiceResponse deleteUser(@PathVariable Long userId) {
        return userService.deleteUser(userId);
    }
}
