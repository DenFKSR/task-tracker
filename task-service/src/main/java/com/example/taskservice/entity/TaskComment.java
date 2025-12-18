package com.example.taskservice.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

/**
 * Представляет комментарий к задаче в системе управления задачами.
 * Каждый комментарий содержит текст, информацию об авторе и привязан к конкретной задаче.
 */
@Getter
@Setter
@Entity
@Table(name = "task")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TaskComment {

    /**
     * Уникальный идентификатор комментария.
     * Генерируется автоматически базой данных.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    /**
     * Текст комментария — содержание, оставленное пользователем.
     */
    String content;

    /**
     * Идентификатор пользователя, оставившего комментарий.
     * Соответствует {@code id} пользователя в {@code auth-service}.
     */
    @Column(name = "author_id")
    Long authorId; // ID из auth-service

    /**
     *
     */
    @ManyToOne
    @JoinColumn(name = "task_id")
    Task task;

    /**
     *
     */
    @Column(name = "created_at")
    LocalDateTime createdAt;

}
