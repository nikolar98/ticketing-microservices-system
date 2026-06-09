package com.pmf.rzk.assignmentservice.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "assignment_history", schema = "nr_assignment_db")
public class AssignmentHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "ticket_id")
    private Long ticketId;

    @Column(name = "old_agent_id")
    private Long oldAgentId;

    @Column(name = "new_agent_id")
    private Long newAgentId;

    @Column(name = "changed_at")
    private Instant changedAt;

    @Size(max = 255)
    @Column(name = "reason")
    private String reason;

}