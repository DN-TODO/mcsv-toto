package com.todo.app.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Table;
import org.springframework.data.relational.core.mapping.Column;
import java.time.LocalDateTime;

@Builder
@Data
@Table("detail_task")
public class DetailTask {
    @Id
    @Column("id_detail_task")
    private Long idDetailTask;

    @Column("comment_detail_task")
    private String commentDetailTask;

    @Column("id_task")
    private Long idTask;

    @Column("created_at")
    private LocalDateTime createdAt;

    @Column("updated_at")
    private LocalDateTime updatedAt;
}
