package com.todo.app.dto;



public record TaskRequestDto(
    String taskTitle,
    String taskDescription,
    Long idState,
    Long userId
) {}
