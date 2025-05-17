package com.todo.app.model;

import lombok.Data;
import lombok.Builder;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.data.relational.core.mapping.Column;
import java.time.LocalDateTime;

@Data
@Builder
@Table("state")
public class State {
    @Id
    @Column("id_state")
    private Long idState;

    @Column("state_description")
    private String stateDescription;

    @Column("state_comment")
    private String stateComment;

    @Column("created_at")
    private LocalDateTime createdAt;

    @Column("updated_at")
    private LocalDateTime updatedAt;
}
