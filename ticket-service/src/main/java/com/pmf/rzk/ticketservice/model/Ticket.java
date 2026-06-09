package com.pmf.rzk.ticketservice.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "tickets", schema = "nr_ticket_db")
public class Ticket {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotBlank(message="Title is required")
    @Size(max = 150, message = "Title should not be longer than 150 characters")
    @Column(name = "title", length = 150)
    private String title;

    @Lob
    @Column(name = "description")
    private String description;

    @NotBlank
    @Size(max = 50, message = "Status should not be longer than 50 characters")
    @Column(name = "status", length = 50)
    private String status;

    @Size(max = 50, message = "Priority should not be longer than 50 characters")
    @Column(name = "priority", length = 50)
    private String priority;

    @Size(max = 50, message = "Type should not be longer than 50 characters")
    @Column(name = "type", length = 50)
    private String type;

    @NotNull(message = "Reporter id is required")
    @Column(name = "reporter_id")
    private Long reporterId;

    @Column(name = "created_at")
    private Instant createdAt;

    @Column(name = "updated_at")
    private Instant updatedAt;

}