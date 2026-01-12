package com.example.taskservice.dto.response;

import com.example.taskservice.dto.request.TaskRequest;
import lombok.*;
import lombok.experimental.FieldDefaults;

@Getter
@Setter
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)
public class TaskResponse extends TaskRequest {

}
