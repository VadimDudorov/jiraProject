package ru.jiraproject.jira.model.response;


import lombok.Builder;

@Builder
public record ServiceResponse(StatusResponse status) {
}
