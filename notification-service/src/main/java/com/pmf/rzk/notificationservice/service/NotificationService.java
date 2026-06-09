package com.pmf.rzk.notificationservice.service;

import com.pmf.rzk.notificationservice.exception.NotificationNotFoundException;
import com.pmf.rzk.notificationservice.model.Notification;
import com.pmf.rzk.notificationservice.repository.NotificationLogRepository;
import com.pmf.rzk.notificationservice.repository.NotificationRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class NotificationService {

    private final NotificationRepository notificationRepository;


    public NotificationService(NotificationRepository notificationRepository) {
        this.notificationRepository = notificationRepository;
    }

    public List<Notification> getAllNotifications() {
        return notificationRepository.findAll();
    }

    public Notification getNotificationById(Long id) {
        return notificationRepository.findById(id)
                .orElseThrow(() -> new NotificationNotFoundException("Notification with id " + id + " not found"));
    }

    public List<Notification> getNotificationsByRecipientId(Long recipientId) {
        return notificationRepository.findByRecipientId(recipientId);
    }

    public List<Notification> getNotificationsByTicketId(Long ticketId) {
        return notificationRepository.findByTicketId(ticketId);
    }

    public Notification createNotification(Notification notification) {
        notification.setCreatedAt(Instant.now());

        return notificationRepository.save(notification);
    }

    public void deleteNotification(Long id) {
        Notification notification = notificationRepository.findById(id)
                .orElseThrow(() -> new NotificationNotFoundException("Notification with id " + id + " not found"));

        notificationRepository.delete(notification);
    }
}