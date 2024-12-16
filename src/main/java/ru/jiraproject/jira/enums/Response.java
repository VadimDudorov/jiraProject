package ru.jiraproject.jira.enums;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Response {
    OK("Операция прошла успешно"),
    ERROR("Операция пройдена не успешно");

    private final String description;
}
