package com.example.notificationservice.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

/**
 * Представляет настройки уведомлений пользователя по типу события.
 * Определяет, через какие каналы (email, Telegram, push-уведомления)
 * пользователь хочет получать уведомления определённого типа.
 */
@Getter
@Setter
@Entity
@Table(name = "notificationPreference")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class NotificationPreference {

    /**
     * Уникальный идентификатор записи настроек уведомления.
     * Генерируется автоматически базой данных.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    /**
     * Идентификатор пользователя, к которому применяются данные настройки.
     * Соответствует {@code id} пользователя в сервисе аутентификации ({@code authservice}).
     */
    @Column(name="user_id")
    Long userId; // ID получателя из authservice

    /**
     * Тип уведомления, для которого задаются настройки (например, {@code TASK_ASSIGNED}, {@code PROJECT_UPDATE}).
     * Каждый тип может иметь отдельные предпочтения доставки.
     */
    NotificationType type;

    /**
     * Флаг, указывающий, разрешена ли отправка уведомлений данного типа по электронной почте.
     * По умолчанию — {@code true}.
     */
    @Column(name="email_enabled")
    Boolean emailEnabled = true;

    /**
     * Флаг, указывающий, разрешена ли отправка уведомлений данного типа через Telegram.
     * По умолчанию — {@code false}.
     */
    @Column(name="telegram_enabled")
    Boolean telegramEnabled = false;

    /**
     * Флаг, указывающий, разрешена ли отправка push-уведомлений данного типа (например, в мобильном приложении).
     * По умолчанию — {@code true}.
     */
    @Column(name="push_enabled")
    Boolean pushEnabled = true;

    /**
     * Дата и время последнего обновления настроек уведомления.
     * Используется для аудита и синхронизации с другими сервисами.
     */
    @Column(name="update_at")
    LocalDateTime updatedAt;

}
