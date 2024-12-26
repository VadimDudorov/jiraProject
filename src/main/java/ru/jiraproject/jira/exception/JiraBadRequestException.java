package ru.jiraproject.jira.exception;

import org.springframework.http.HttpStatus;

public class JiraBadRequestException extends JiraException {

  public JiraBadRequestException(String message) {

    super(message, HttpStatus.BAD_REQUEST);
  }
}
