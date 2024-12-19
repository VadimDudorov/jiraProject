package ru.jiraproject.jira.util;

import ru.jiraproject.jira.model.response.ServiceResponse;
import ru.jiraproject.jira.model.response.StatusResponse;

import static ru.jiraproject.jira.enums.ResponseResultStatus.SUCCESS;

public class ResponseOK {
    public static ServiceResponse statusOK(){
        return ServiceResponse.builder().status(StatusResponse.builder()
                .code(200)
                .status(SUCCESS.getValue())
                .message("Операция выполнена успешно")
                .build()).build();
    }
}
