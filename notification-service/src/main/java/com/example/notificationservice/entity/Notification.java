package com.example.notificationservice.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "notification")
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Long userId; // ID получателя из authservice
    String title;
    String message;
    NotificationType type;
    NotificationStatus status = NotificationStatus.UNREAD;
    RelatedEntityType relatedEntityType; // TASK, PROJECT, etc.
    Long relatedEntityId;
    SentVia sentVia; // EMAIL, TELEGRAM, PUSH
    LocalDateTime createdAt;
    LocalDateTime readAt;
}
