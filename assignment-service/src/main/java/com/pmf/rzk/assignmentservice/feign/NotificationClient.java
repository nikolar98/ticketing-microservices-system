package com.pmf.rzk.assignmentservice.feign;

import com.pmf.rzk.assignmentservice.dto.NotificationRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(name = "notification-service")
public interface NotificationClient {

    @PostMapping("/notifications")
    void createNotification(@RequestBody NotificationRequest notificationRequest);
}