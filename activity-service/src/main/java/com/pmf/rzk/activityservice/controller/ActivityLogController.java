package com.pmf.rzk.activityservice.controller;

import com.pmf.rzk.activityservice.model.ActivityLog;
import com.pmf.rzk.activityservice.service.ActivityLogService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
public class ActivityLogController {

    private final ActivityLogService activityLogService;

    public ActivityLogController(ActivityLogService activityLogService) {
        this.activityLogService = activityLogService;
    }

    @GetMapping("/activity-logs")
    public List<ActivityLog> getAllActivityLogs() {
        return activityLogService.getAllActivityLogs();
    }

    @GetMapping("/activity-logs/{id}")
    public ActivityLog getActivityLogById(@PathVariable @Min(1) Long id) {
        return activityLogService.getActivityLogById(id);
    }

    @GetMapping("/activity-logs/ticket/{ticketId}")
    public List<ActivityLog> getActivityLogsByTicketId(@PathVariable @Min(1) Long ticketId) {
        return activityLogService.getActivityLogsByTicketId(ticketId);
    }

    @PostMapping("/activity-logs")
    public ActivityLog createActivityLog(@Valid @RequestBody ActivityLog activityLog) {
        return activityLogService.createActivityLog(activityLog);
    }

    @DeleteMapping("/activity-logs/{id}")
    public void deleteActivityLog(@PathVariable @Min(1) Long id) {
        activityLogService.deleteActivityLog(id);
    }
}