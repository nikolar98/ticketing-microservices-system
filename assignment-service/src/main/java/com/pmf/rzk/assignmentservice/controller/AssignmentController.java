package com.pmf.rzk.assignmentservice.controller;

import com.pmf.rzk.assignmentservice.model.Assignment;
import com.pmf.rzk.assignmentservice.model.AssignmentHistory;
import com.pmf.rzk.assignmentservice.service.AssignmentService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
public class AssignmentController {

    private final AssignmentService assignmentService;

    public AssignmentController(AssignmentService assignmentService) {
        this.assignmentService = assignmentService;
    }

    @GetMapping("/assignments")
    public List<Assignment> getAllAssignments() {
        return assignmentService.getAllAssignments();
    }

    @GetMapping("/assignments/{id}")
    public Assignment getAssignmentById(@PathVariable @Min(1) Long id) {
        return assignmentService.getAssignmentById(id);
    }

    @PostMapping("/assignments")
    public Assignment createAssignment(@Valid @RequestBody Assignment assignment) {
        return assignmentService.createAssignment(assignment);
    }

    @DeleteMapping("/assignments/{id}")
    public void deleteAssignment(@PathVariable @Min(1) Long id) {
        assignmentService.deleteAssignment(id);
    }

    @GetMapping("/assignments/history/ticket/{ticketId}")
    public List<AssignmentHistory> getHistoryByTicketId(
            @PathVariable @Min(1) Long ticketId) {
        return assignmentService.getHistoryByTicketId(ticketId);
    }
}