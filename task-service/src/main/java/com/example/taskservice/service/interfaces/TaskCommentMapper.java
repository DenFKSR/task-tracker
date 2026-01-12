package com.example.taskservice.service.interfaces;

import com.example.taskservice.dto.response.TaskCommentResponse;
import com.example.taskservice.entity.TaskComment;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface TaskCommentMapper {
    TaskCommentMapper INSTANCE = Mappers.getMapper(TaskCommentMapper.class);

    TaskCommentResponse toResponse(TaskComment taskComment);

}
