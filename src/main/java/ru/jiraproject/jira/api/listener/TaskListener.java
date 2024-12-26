package ru.jiraproject.jira.api.listener;

import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import ru.jiraproject.jira.service.TaskService;

@Service
@RequiredArgsConstructor
public class TaskListener {

  private final TaskService taskService;

  @KafkaListener(
      id = "post_task_data_listener",
      groupId = "${spring.kafka.consumer.group-id}",
      topics = "post_task"
  )
  public void postTask(String message) {

    taskService.postTaskKafka(message);
  }
}
