package com.todo.app.mapper;

import com.todo.app.model.State;

import java.time.format.DateTimeFormatter;

import org.springframework.stereotype.Component;

import com.todo.app.dto.StateRequestDto;
import com.todo.app.dto.StateResponseDto;

@Component
public class StateMapper {

    DateTimeFormatter format_request = DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss");
    DateTimeFormatter format_response = DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

    public State toEntity(StateRequestDto dto) {
        return State.builder()
            .stateDescription(dto.stateDescription())
            .stateComment(dto.stateComment())
            .build();
    }

    public StateResponseDto toResponse(State entity) {
        return StateResponseDto.builder()
            .idState(entity.getIdState())
            .stateDescription(entity.getStateDescription())
            .stateComment(entity.getStateComment())
            .createdAt(entity.getCreatedAt().format(format_response))
            .updatedAt(entity.getUpdatedAt().format(format_response))
            .build();
    }
}
