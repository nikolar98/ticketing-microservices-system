package com.pmf.rzk.ticketservice.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "ticket_status_history", schema = "nr_ticket_db")
public class TicketStatusHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "ticket_id")
    private Long ticketId;

    @Size(max = 50)
    @Column(name = "old_status", length = 50)
    private String oldStatus;

    @Size(max = 50)
    @Column(name = "new_status", length = 50)
    private String newStatus;

    @Column(name = "changed_at")
    private Instant changedAt;

}