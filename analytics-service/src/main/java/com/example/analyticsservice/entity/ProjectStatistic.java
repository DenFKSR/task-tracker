package com.example.analyticsservice.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.Setter;
import lombok.experimental.FieldDefaults;
import java.util.Date;

/**
 * Представляет статистику по проекту на определённую дату.
 */
@Getter
@Setter
@Entity
@Table(name = "project_statistic")
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ProjectStatistic {

    /**
     * Уникальный идентификатор записи статистики.
     * Генерируется автоматически базой данных.
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    /**
     * Идентификатор проекта, к которому относится данная статистика.
     */
    @Column(name = "project_id")
    Long projectId;

    /**
     * Дата, за которую собрана статистика.
     */
    @Column(name = "stat_date")
    Date statDate;

    /**
     * Общее количество задач в проекте на указанную дату.
     * По умолчанию — 0.
     */
    @Column(name = "total_tasks")
    Integer totalTasks = 0;

    /**
     * Количество завершённых задач в проекте на указанную дату.
     * По умолчанию — 0.
     */
    @Column(name = "completed_tasks")
    Integer completedTasks = 0;

    /**
     * Процент завершённых задач относительно общего количества задач.
     * По умолчанию — 0.0.
     */
    @Column(name = "completion_percentage")
    Double completionPercentage = 0.0;

    /**
     * Среднее время выполнения одной задачи в днях.
     * По умолчанию — 0.0.
     */
    @Column(name = "avg_task_completion_time_days")
    Double avgTaskCompletionTimeDays = 0.0;

    /**
     * Оценка продуктивности??????
     * По умолчанию — 0.0.
     */
    @Column(name = "team_productivity_score")
    Double teamProductivityScore = 0.0;
}
