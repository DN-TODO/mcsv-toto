package com.todo.app.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.data.relational.core.mapping.Column;
import java.time.LocalDateTime;

@Builder
@Data
@Table("task")
public class Task {
    @Id
    @Column("id_task")
    private Long idTask;

    @Column("task_title")
    private String taskTitle;

    @Column("task_description")
    private String taskDescription;

    @Column("id_state")
    private Long idState;

    @Column("user_id")
    private Long userId;

    @Column("created_at")
    private LocalDateTime createdAt;

    @Column("updated_at")
    private LocalDateTime updatedAt;
}
