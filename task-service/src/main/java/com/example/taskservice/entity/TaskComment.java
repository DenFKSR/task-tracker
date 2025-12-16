package com.example.taskservice.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;
@Getter
@Setter
@Entity
@Table(name = "task")
public class TaskComment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    String content;
    Long authorId; // ID из auth-service
    @OneToOne
    @JoinColumn(name = "task_id")
    Task task;
    LocalDateTime createdAt;

}
