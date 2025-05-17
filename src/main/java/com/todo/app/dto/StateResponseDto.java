package com.todo.app.dto;

import lombok.Builder;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@Builder
@AllArgsConstructor
public class StateResponseDto {
    private Long idState;
    private String stateDescription;
    private String stateComment;
    private String createdAt;
    private String updatedAt;
}
