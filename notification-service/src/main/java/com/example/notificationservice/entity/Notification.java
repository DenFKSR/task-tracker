package com.example.notificationservice.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

/**
 * Представляет уведомление, отправленное пользователю системы.
 * Уведомление содержит информацию о событии (например, обновление задачи или проекта),
 * способе доставки, статусе прочтения и связанной сущности.
 */
@Getter
@Setter
@Entity
@Table(name = "notification")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class Notification {

    /**
     * Уникальный идентификатор уведомления.
     * Генерируется автоматически базой данных.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    /**
     * Идентификатор пользователя-получателя уведомления.
     * Соответствует {@code id} пользователя в сервисе аутентификации ({@code authservice}).
     */
    @Column(name="user_id")
    Long userId; // ID получателя из authservice

    /**
     * Заголовок уведомления — краткое описание события.
     * Отображается в интерфейсе пользователя или в письме.
     */
    String title;

    /**
     * Основной текст уведомления с подробностями о событии.
     */
    String message;

    /**
     * Тип уведомления (например, {@code TASK_ASSIGNED}, {@code TASK_UPDATED}, {@code DEADLINE_SOON}).
     * Используется для определения приоритета или визуального оформления.
     */
    NotificationType type;

    /**
     * Текущий статус уведомления.
     * По умолчанию — {@link NotificationStatus#UNREAD}.
     */
    NotificationStatus status = NotificationStatus.UNREAD;

    /**
     * Тип связанной сущности, которая вызвала уведомление.
     * Например: {@code TASK}, {@code PROJECT}, {@code etc}
     */
    @Column(name="related_entity_type")
    RelatedEntityType relatedEntityType; // TASK, PROJECT, etc.

    /**
     * Идентификатор связанной сущности (например, ID задачи или проекта).
     * Позволяет пользователю перейти к соответствующему ресурсу при клике.
     */
    @Column(name="related_entity_id")
    Long relatedEntityId;

    /**
     * Канал, через который было отправлено уведомление.
     */
    @Column(name="sent_via")
    SentVia sentVia; // EMAIL, TELEGRAM, PUSH

    /**
     * Дата и время создания уведомления.
     */
    @Column(name="created_at")
    LocalDateTime createdAt;

    /**
     * Дата и время, когда пользователь прочитал уведомление.
     */
    @Column(name="read_at")
    LocalDateTime readAt;
}
