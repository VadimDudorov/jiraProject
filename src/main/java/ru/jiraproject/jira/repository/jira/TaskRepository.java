package ru.jiraproject.jira.repository.jira;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.jiraproject.jira.model.entity.TaskEntity;

public interface TaskRepository extends JpaRepository<TaskEntity, Long> {

}
