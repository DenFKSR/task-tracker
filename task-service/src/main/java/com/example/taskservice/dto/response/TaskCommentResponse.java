package com.example.taskservice.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TaskCommentResponse {
    Long id;
    String content;
    TaskResponse task;
    @JsonFormat(pattern = "dd.MM.yyyy")
    LocalDateTime createdAt;
}
