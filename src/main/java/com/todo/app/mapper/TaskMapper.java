package com.todo.app.mapper;

import com.todo.app.model.Task;

import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Component;

import com.todo.app.dto.TaskRequestDto;
import com.todo.app.dto.TaskResponseDto;

@Component
public class TaskMapper {

    DateTimeFormatter format_request = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
    DateTimeFormatter format_response = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");    

    public Task toEntity(TaskRequestDto dto) {
        return Task.builder()
            .taskTitle(dto.taskTitle())
            .taskDescription(dto.taskDescription())
            .idState(dto.idState())
            .userId(dto.userId())
            .build();

    }

    public TaskResponseDto toResponse(Task entity) {
        return TaskResponseDto.builder()
            .idTask(entity.getIdTask())
            .taskTitle(entity.getTaskTitle())
            .taskDescription(entity.getTaskDescription())
            .idState(entity.getIdState())
            .userId(entity.getUserId())
            .createdAt(entity.getCreatedAt().format(format_response))
            .updatedAt(entity.getUpdatedAt().format(format_response))
            .build();
    }
}
