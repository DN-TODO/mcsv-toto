package com.todo.app.mapper;

import com.todo.app.model.DetailTask;


import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Component;

import com.todo.app.dto.DetailTaskRequestDto;
import com.todo.app.dto.DetailTaskResponseDto;

@Component
public class DetailTaskMapper {

    DateTimeFormatter format_request = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
    DateTimeFormatter format_response = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

    public DetailTask toEntity(DetailTaskRequestDto dto) {


        return DetailTask.builder()
                .idTask(dto.idTask())
                .commentDetailTask(dto.commentDetailTask())
                .build();
    }

    public DetailTaskResponseDto toResponse(DetailTask entity) {
        return DetailTaskResponseDto.builder()
                .idDetailTask(entity.getIdDetailTask())
                .commentDetailTask(entity.getCommentDetailTask())
                .createdAt(entity.getCreatedAt().format(format_response))
                .updatedAt(entity.getUpdatedAt().format(format_response))
                .build();
    }
}
