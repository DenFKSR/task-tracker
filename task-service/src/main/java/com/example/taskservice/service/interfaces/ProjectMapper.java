package com.example.taskservice.service.interfaces;

import com.example.taskservice.dto.response.ProjectResponse;
import com.example.taskservice.entity.Project;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(uses = TaskMapper.class)
public interface ProjectMapper {
    ProjectMapper INSTANCE = Mappers.getMapper(ProjectMapper.class);

    ProjectResponse toResponse(Project project);
}
