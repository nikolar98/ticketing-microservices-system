package com.pmf.rzk.assignmentservice.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "assignments", schema = "nr_assignment_db")
public class Assignment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotNull(message = "Ticket id is required")
    @Column(name = "ticket_id")
    private Long ticketId;

    @NotNull(message = "Agent id is required")
    @Column(name = "agent_id")
    private Long agentId;

    @Column(name = "assigned_at")
    private Instant assignedAt;

    @Column(name = "active")
    private Boolean active;

}