package com.example.taskservice.dto.request;

import com.example.taskservice.dto.response.TaskResponse;
import lombok.*;
import lombok.experimental.FieldDefaults;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TaskCommentRequest {

    Long id;
    String content;
    TaskResponse task;
}
