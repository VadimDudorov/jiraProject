package ru.jiraproject.jira.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.messaging.support.ErrorMessage;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import ru.jiraproject.jira.exception.JiraBadRequestException;
import ru.jiraproject.jira.exception.JiraException;
import ru.jiraproject.jira.exception.JiraNotFoundException;
import ru.jiraproject.jira.model.response.ServiceResponse;
import ru.jiraproject.jira.model.response.StatusResponse;


import static ru.jiraproject.jira.enums.ResponseResultStatus.BAD_REQUEST;
import static ru.jiraproject.jira.enums.ResponseResultStatus.NOT_FOUND;
import static ru.jiraproject.jira.enums.ResponseResultStatus.ERROR;

@RestControllerAdvice
public class ErrorResponseHandler {

  @ExceptionHandler(Throwable.class)
  public ResponseEntity<ServiceResponse> handlerException(Throwable ex) {

    JiraException jiraException;
    String status = ERROR.getValue();

    if (ex instanceof JiraNotFoundException exCast) {
      jiraException = exCast;
      status = NOT_FOUND.getValue();
    } else if (ex instanceof JiraBadRequestException exCast) {
      jiraException = exCast;
      status = BAD_REQUEST.getValue();
    } else {
      jiraException = new JiraException(ex.getMessage(), HttpStatus.EXPECTATION_FAILED);
    }

    ServiceResponse serviceResponse = ServiceResponse.builder().status(StatusResponse.builder()
        .code(jiraException.getHttpStatus().value())
        .status(status)
        .message(ex.getMessage())
        .build()).build();

    return ResponseEntity.status(jiraException.getHttpStatus().value()).body(serviceResponse);
  }
}