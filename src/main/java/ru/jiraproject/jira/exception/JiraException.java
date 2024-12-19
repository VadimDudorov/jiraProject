package ru.jiraproject.jira.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class JiraException extends RuntimeException{
    private final HttpStatus httpStatus;
    public JiraException(String message, HttpStatus httpStatus) {
        super(message);
        this.httpStatus = httpStatus;
    }
}
