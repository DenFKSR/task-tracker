package com.example.notificationservice.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Getter
@Setter
@Entity
@Table(name = "notificationPreference")
public class NotificationPreference {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;
    Long userId; // ID получателя из authservice
    NotificationType type;
    Boolean emailEnabled = true;
    Boolean telegramEnabled = false;
    Boolean pushEnabled = true;
    LocalDateTime updatedAt;

}
