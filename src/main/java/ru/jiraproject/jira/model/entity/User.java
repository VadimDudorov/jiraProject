package ru.jiraproject.jira.model.entity;

import jakarta.persistence.*;
import lombok.Data;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity
@Table(name = "users", schema = "jira")
public class User {

    @Id
    @GeneratedValue
    @Column(name = "user_id")
    Long userId;
    @Column(name = "first_name")
    String firstName;
    @Column(name = "last_name")
    String lastName;
    @Column(name = "birth_date")
    LocalDateTime birthDate;
    @Column(name = "role")
    String role;
    @OneToMany(mappedBy = "user")
    List<Task> tasks;
    @CreationTimestamp
    @Column(name = "timestamp_cr")
    LocalDateTime timestampCr;
    @UpdateTimestamp
    @Column(name = "timestamp_up")
    LocalDateTime timestampUp;
}
