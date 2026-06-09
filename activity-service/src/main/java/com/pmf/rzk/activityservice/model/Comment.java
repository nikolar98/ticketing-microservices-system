package com.pmf.rzk.activityservice.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "comments", schema = "nr_activity_db")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotNull(message = "Ticket id is required")
    @Column(name = "ticket_id")
    private Long ticketId;

    @NotNull(message = "User id is required")
    @Column(name = "user_id")
    private Long userId;

    @NotBlank(message = "Content is required")
    @Lob
    @Column(name = "content")
    private String content;

    @Column(name = "created_at")
    private Instant createdAt;

}