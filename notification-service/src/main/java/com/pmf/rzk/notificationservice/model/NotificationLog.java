package com.pmf.rzk.notificationservice.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "notification_logs", schema = "nr_notification_db")
public class NotificationLog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "notification_id")
    private Long notificationId;

    @Column(name = "sent_at")
    private Instant sentAt;

    @Size(max = 50)
    @Column(name = "delivery_status", length = 50)
    private String deliveryStatus;

}