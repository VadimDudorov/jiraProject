package ru.jiraproject.jira.api.listener;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;
import ru.jiraproject.jira.model.entity.TaskEntity;
import ru.jiraproject.jira.repository.jira.TaskRepository;

@Service
@RequiredArgsConstructor
public class TaskListener {
    private final TaskRepository taskRepository;
    @KafkaListener(
            id = "post_task_data_listener",
            groupId = "${spring.kafka.consumer.group-id}",
            topics = "post_task"
    )
    public void postTask(String message){
        ObjectMapper objectMapper = new ObjectMapper();
        TaskEntity taskEntity;
        try {
            taskEntity = objectMapper.readValue(message, TaskEntity.class);
        } catch (Exception e){
         throw new RuntimeException(e.getMessage());
        }
        taskRepository.save(taskEntity);
    }
}
