package ru.jiraproject.jira.model.entity;

import javax.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import ru.jiraproject.jira.enums.Status;

import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "tasks", schema = "jira")
public class TaskEntity {

  @Id
  @GeneratedValue
  @Column(name = "task_id")
  Long taskId;
  @Column(name = "story_point")
  Long storyPoint;
  @Column(name = "description")
  String description = "descTest";
  @Column(name = "status")
  @Enumerated(EnumType.STRING)
  Status status;
  @ManyToOne
  @JoinColumn(name = "user_id")
  UserEntity user;
  @ManyToOne
  @JoinColumn(name = "project_id")
  ProjectEntity project;
  @CreationTimestamp
  @Column(name = "timestamp_cr")
  LocalDateTime timestampCr;
  @UpdateTimestamp
  @Column(name = "timestamp_up")
  LocalDateTime timestampUp;
}
