package com.example.taskservice.service.interfaces;

import com.example.taskservice.dto.response.TaskResponse;
import com.example.taskservice.entity.Task;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TaskMapper {
    TaskMapper INSTANCE = Mappers.getMapper(TaskMapper.class);

    TaskResponse toResponse(Task task);
}
