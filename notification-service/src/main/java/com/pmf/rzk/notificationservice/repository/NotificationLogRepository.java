package com.pmf.rzk.notificationservice.repository;

import com.pmf.rzk.notificationservice.model.NotificationLog;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface NotificationLogRepository extends JpaRepository<NotificationLog, Long> {
    List<NotificationLog> findByNotificationId(Long notificationId);
}
