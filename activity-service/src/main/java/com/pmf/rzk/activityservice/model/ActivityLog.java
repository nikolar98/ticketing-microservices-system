package com.pmf.rzk.activityservice.model;

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
@Table(name = "activity_logs", schema = "nr_activity_db")
public class ActivityLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotNull(message = "Ticket id is required")
    @Column(name = "ticket_id")
    private Long ticketId;

    @NotBlank(message = "Activity type is required")
    @Size(max = 100, message = "Activity type should not be longer than 100 characters")
    @Column(name = "activity_type", length = 100)
    private String activityType;

    @Lob
    @Column(name = "description")
    private String description;

    @Column(name = "created_at")
    private Instant createdAt;

}