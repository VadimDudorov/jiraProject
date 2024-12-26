package ru.jiraproject.jira.model.response;

import lombok.Builder;

@Builder
public record StatusResponse(Integer code, String status, String message) {

}
