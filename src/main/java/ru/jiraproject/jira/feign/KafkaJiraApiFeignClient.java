package ru.jiraproject.jira.feign;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import ru.jiraproject.jira.model.dto.taskDto.TaskDto;

@FeignClient(name = "kafkaPostTaskFeignClient", url = "${jira.external.kafkaProduceTask}")
public interface KafkaJiraApiFeignClient {

  @PostMapping("/api/v1.0/postTask")
  void postTaskJira(TaskDto taskDto);
}