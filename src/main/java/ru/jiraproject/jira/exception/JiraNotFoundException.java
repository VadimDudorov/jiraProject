package ru.jiraproject.jira.exception;

import org.springframework.http.HttpStatus;

public class JiraNotFoundException extends JiraException{
    public JiraNotFoundException(String message, HttpStatus httpStatus) {
        super(message, httpStatus);
    }
}
