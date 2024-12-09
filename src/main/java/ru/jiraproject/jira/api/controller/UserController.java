package ru.jiraproject.jira.api.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import ru.jiraproject.jira.model.dto.userDto.UserDto;
import ru.jiraproject.jira.model.dto.userDto.UserResponce;
import ru.jiraproject.jira.service.UserService;

@RestController
@RequestMapping({"/api/v1.0"})
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/user")
    public UserResponce getUser(Long userId){
        return userService.getUser(userId);
    }

    @PostMapping("/user")
    public UserResponce postUser(@RequestBody UserDto userDto) {
        return userService.postUser(userDto);
    }

    @PatchMapping("/user")
    public UserResponce patchUser(@RequestBody UserDto userDto) {
        return userService.patchUser(userDto);
    }

    @DeleteMapping("/user")
    public String deleteUser(Long userId) {
        return userService.deleteUser(userId);
    }
}
