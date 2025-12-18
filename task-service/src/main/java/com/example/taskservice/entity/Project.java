package com.example.taskservice.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

/**
 * Представляет проект в системе управления задачами.
 * Проект объединяет набор связанных задач и содержит метаданные,
 * такие как название, описание, статус и информация о создателе.
 */
@Getter
@Setter
@Entity
@Table(name = "project")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Project {

    /**
     * Уникальный идентификатор проекта.
     * Генерируется автоматически базой данных.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    /**
     * Название проекта — краткий идентификатор, отображаемый пользователю.
     */
    String name;

    /**
     * Описание проекта — дополнительная информация о целях, задачах или контексте проекта.
     */
    String description;

    /**
     * Идентификатор пользователя, создавшего проект.
     */
    @Column(name="created_by")
    Long createdBy; // ID пользователя из auth-service

    /**
     * Текущий статус проекта (например, {@code ACTIVE}, {@code COMPLETED}, {@code ARCHIVED}).
     */
    ProjectStatus status = ProjectStatus.ACTIVE;

    /**
     * Список задач, связанных с этим проектом.
     * Отображает связь "один ко многим": один проект — много задач.
     */
    @OneToMany
    @JoinColumn(name = "task_id")
    List <Task> tasks = new ArrayList<>();

    /**
     * Дата и время создания проекта.
     */
    @Column(name="created_at")
    LocalDateTime createdAt;

    /**
     * Дата и время последнего обновления проекта.
     */
    @Column(name="update_at")
    LocalDateTime updatedAt;
}
