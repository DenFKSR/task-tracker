package com.example.analyticsservice.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;

import java.util.Date;

/**
 * Представляет статистику по пользователю на определённую дату.
 */
@Getter
@Setter
@Entity
@Table(name= "user_statistic")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class UserStatistic {

    /**
     * Уникальный идентификатор записи статистики.
     * Генерируется автоматически базой данных.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    /**
     * Идентификатор пользователя, к которому относится данная статистика.
     */
    @Column(name = "user_id")
    Long userId;

    /**
     * Дата, за которую собрана статистика.
     */
    @Column(name = "stat_date")
    Date statDate;

    /**
     * Созданные задачи
     * По умолчанию — 0.
     */
    @Column(name = "tasks_created")
    Integer tasksCreated = 0;

    /**
     * Выполненные задачи
     * По умолчанию — 0.
     */
    @Column(name = "tasks_completed")
    Integer tasksCompleted = 0;

    /**
     * Задачи находящиеся в процессе выполнения
     * По умолчанию — 0.
     */
    @Column(name = "tasks_in_progress")
    Integer tasksInProgress = 0;

    /**
     * Общее время, затраченное пользователем на выполнение задач, в минутах.
     * По умолчанию — 0.
     */
    @Column(name = "total_time_spent_minutes")
    Integer totalTimeSpentMinutes = 0;

    /**
     * Среднее время, затрачиваемое пользователем на выполнение одной задачи, в часах.
     * По умолчанию — 0.0.
     */
    @Column(name = "avg_completion_time_hours")
    Double avgCompletionTimeHours = 0.0;

    /**
     * Процент задач, завершённых вовремя (в пределах установленного дедлайна).
     * По умолчанию — 0.0.
     */
    @Column(name = "on_time_completion_rate")
    Double onTimeCompletionRate = 0.0;
}
