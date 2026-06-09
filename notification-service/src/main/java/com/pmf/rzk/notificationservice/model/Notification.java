package com.pmf.rzk.notificationservice.model;

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
@Table(name = "notifications", schema = "nr_notification_db")
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotNull(message = "Ticket id is required")
    @Column(name = "ticket_id")
    private Long ticketId;

    @NotNull(message = "Recipient id is required")
    @Column(name = "recipient_id")
    private Long recipientId;

    @NotBlank(message = "Message is required")
    @Size(max = 1000)
    @Lob
    @Column(name = "message")
    private String message;

    @Column(name = "created_at")
    private Instant createdAt;

}