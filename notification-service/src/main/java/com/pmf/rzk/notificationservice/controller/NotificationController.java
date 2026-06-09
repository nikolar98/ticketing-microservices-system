package com.pmf.rzk.notificationservice.controller;

import com.pmf.rzk.notificationservice.model.Notification;
import com.pmf.rzk.notificationservice.service.NotificationService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
public class NotificationController {

    private final NotificationService notificationService;

    public NotificationController(NotificationService notificationService) {
        this.notificationService = notificationService;
    }

    @GetMapping("/notifications")
    public List<Notification> getAllNotifications() {
        return notificationService.getAllNotifications();
    }

    @GetMapping("/notifications/{id}")
    public Notification getNotificationById(@PathVariable @Min(1) Long id) {
        return notificationService.getNotificationById(id);
    }

    @GetMapping("/notifications/recipient/{recipientId}")
    public List<Notification> getNotificationsByRecipientId(@PathVariable @Min(1) Long recipientId) {
        return notificationService.getNotificationsByRecipientId(recipientId);
    }

    @GetMapping("/notifications/ticket/{ticketId}")
    public List<Notification> getNotificationsByTicketId(@PathVariable @Min(1) Long ticketId) {
        return notificationService.getNotificationsByTicketId(ticketId);
    }

    @PostMapping("/notifications")
    public Notification createNotification(@Valid @RequestBody Notification notification) {
        return notificationService.createNotification(notification);
    }

    @DeleteMapping("/notifications/{id}")
    public void deleteNotification(@PathVariable @Min(1) Long id) {
        notificationService.deleteNotification(id);
    }


}