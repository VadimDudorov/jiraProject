package ru.jiraproject.jira.repository.jira;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.jiraproject.jira.model.entity.ProjectEntity;

public interface ProjectRepository extends JpaRepository<ProjectEntity, Long> {

}
