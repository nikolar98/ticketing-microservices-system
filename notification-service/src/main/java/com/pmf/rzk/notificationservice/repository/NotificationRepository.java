package com.pmf.rzk.notificationservice.repository;

import com.pmf.rzk.notificationservice.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotificationRepository extends JpaRepository<Notification, Long> {
    List<Notification> findByRecipientId(Long recipientId);

    List<Notification> findByTicketId(Long ticketId);
}
