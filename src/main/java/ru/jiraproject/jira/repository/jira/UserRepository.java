package ru.jiraproject.jira.repository.jira;

import org.springframework.data.jpa.repository.JpaRepository;
import ru.jiraproject.jira.model.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

}
