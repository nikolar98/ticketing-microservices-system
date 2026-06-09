package com.pmf.rzk.activityservice.service;

import com.pmf.rzk.activityservice.exception.ActivityLogNotFoundException;
import com.pmf.rzk.activityservice.model.ActivityLog;
import com.pmf.rzk.activityservice.repository.ActivityLogRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class ActivityLogService {

    private final ActivityLogRepository activityLogRepository;

    public ActivityLogService(ActivityLogRepository activityLogRepository) {
        this.activityLogRepository = activityLogRepository;
    }

    public List<ActivityLog> getAllActivityLogs() {
        return activityLogRepository.findAll();
    }

    public ActivityLog getActivityLogById(Long id) {
        return activityLogRepository.findById(id)
                .orElseThrow(() -> new ActivityLogNotFoundException("Activity log with id " + id + " not found"));
    }

    public List<ActivityLog> getActivityLogsByTicketId(Long ticketId) {
        return activityLogRepository.findByTicketId(ticketId);
    }

    public ActivityLog createActivityLog(ActivityLog activityLog) {
        activityLog.setCreatedAt(Instant.now());
        return activityLogRepository.save(activityLog);
    }

    public void deleteActivityLog(Long id) {
        ActivityLog activityLog = activityLogRepository.findById(id)
                .orElseThrow(() -> new ActivityLogNotFoundException("Activity log with id " + id + " not found"));

        activityLogRepository.delete(activityLog);
    }
}