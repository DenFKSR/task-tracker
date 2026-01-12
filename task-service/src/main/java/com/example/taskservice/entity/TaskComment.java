package com.example.taskservice.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
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
@Table(name = "task_comment")
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
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "task_id", nullable = false)
    Task task;

    /**
     *
     */
    @Column(name = "created_at")
    @JsonFormat(pattern = "dd.MM.yyyy")
    LocalDateTime createdAt;

}
