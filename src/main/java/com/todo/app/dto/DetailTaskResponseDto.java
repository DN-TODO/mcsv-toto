package com.todo.app.dto;

import lombok.Builder;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class DetailTaskResponseDto {
    private Long idDetailTask;
    private String commentDetailTask;
    private Long idTask;
    private String createdAt;
    private String updatedAt;
}
