package com.example.taskservice.entity;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Представляет задачу в системе управления проектами.
 * Задача принадлежит одному проекту, имеет статус, приоритет, автора, исполнителя,
 * срок выполнения, оценку трудозатрат и список комментариев.
 */
@Getter
@Setter
@Entity
@Table(name = "task")
public class Task {

    /**
     * Уникальный идентификатор задачи.
     * Генерируется автоматически базой данных.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    /**
     * Заголовок (название) задачи — краткое описание сути задачи.
     */
    @Column(unique = true, nullable = false)
    String title;

    /**
     * Подробное описание задачи, включая требования, контекст или инструкции.
     */
    String description;

    /**
     * Текущий статус задачи (например, {@code TODO}, {@code IN_PROGRESS}, {@code DONE}).
     */
    TaskStatus status;

    /**
     * Приоритет задачи (например, {@code LOW}, {@code MEDIUM}, {@code HIGH}, {@code URGENT}).
     */
    Priority priority;

    /**
     * Идентификатор пользователя, создавшего задачу.
     * Соответствует {@code id} пользователя в {@code auth-service}.
     */
    @Column(name = "author_id")
    Long authorId; // ID из authservice

    /**
     * Идентификатор пользователя, которому назначена задача (исполнитель).
     * Также соответствует {@code id} в {@code auth-service}.
     */
    @Column(name = "assignee_id")
    Long assigneeId; // ID из authservice

    /**
     * Проект, к которому относится задача.
     * Связь "многие к одному": множество задач могут принадлежать одному проекту.
     */
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "project_id")
    //@JsonBackReference("project_tasks")
    Project project;

    /**
     * Планируемая дата и время завершения задачи.
     * Используется для контроля сроков выполнения.
     */
    @Column(name = "due_date")
    LocalDateTime dueDate;


    /**
     * Время на выполнение задачи
     */
    @Column(name = "estimate_hours")
    Double estimatedHours;

    /**
     * Список комментариев, оставленных к задаче.
     * Связь "один ко многим": одна задача — много комментариев.
     */
    @OneToMany(mappedBy = "task", cascade = CascadeType.ALL, orphanRemoval = true)
    List <TaskComment> comments = new ArrayList<>();

    /**
     * Дата и время создания задачи.
     */
    @Column(name = "created_at")
    LocalDateTime createdAt;

    /**
     * Дата и время последнего обновления задачи.
     */
    @Column(name = "updated_at")
    LocalDateTime updatedAt;
}
