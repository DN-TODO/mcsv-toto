package com.todo.app.dto;

import lombok.Builder;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class TaskResponseDto {
    private Long idTask;
    private String taskTitle;
    private String taskDescription;
    private Long idState;
    private Long userId;
    private String createdAt;
    private String updatedAt;
}
