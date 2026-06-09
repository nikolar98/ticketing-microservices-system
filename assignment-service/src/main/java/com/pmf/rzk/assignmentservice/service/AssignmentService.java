package com.pmf.rzk.assignmentservice.service;

import com.pmf.rzk.assignmentservice.dto.NotificationRequest;
import com.pmf.rzk.assignmentservice.exception.AssignmentNotFoundException;
import com.pmf.rzk.assignmentservice.feign.NotificationClient;
import com.pmf.rzk.assignmentservice.model.Assignment;
import com.pmf.rzk.assignmentservice.model.AssignmentHistory;
import com.pmf.rzk.assignmentservice.repository.AssignmentHistoryRepository;
import com.pmf.rzk.assignmentservice.repository.AssignmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AssignmentService {

    private final AssignmentRepository assignmentRepository;
    private final AssignmentHistoryRepository assignmentHistoryRepository;
    private final NotificationClient notificationClient;

    public List<Assignment> getAllAssignments() {
        return assignmentRepository.findAll();
    }

    public Assignment getAssignmentById(Long id) {
        return assignmentRepository.findById(id)
                .orElseThrow(() -> new AssignmentNotFoundException("Assignment with id " + id + " not found"));
    }

    //
    public Assignment createAssignment(Assignment assignment) {
        assignment.setAssignedAt(Instant.now());

        if (assignment.getActive() == null) {
            assignment.setActive(true);
        }

        Assignment savedAssignment = assignmentRepository.save(assignment);

        AssignmentHistory history = new AssignmentHistory();
        history.setTicketId(savedAssignment.getTicketId());
        history.setOldAgentId(null);
        history.setNewAgentId(savedAssignment.getAgentId());
        history.setChangedAt(Instant.now());
        history.setReason("Initial assignment");

        assignmentHistoryRepository.save(history);

        NotificationRequest notificationRequest =
                new NotificationRequest(savedAssignment.getTicketId(), savedAssignment.getAgentId(),
                        "You have been assigned to ticket " + savedAssignment.getTicketId());

        notificationClient.createNotification(notificationRequest);

        return savedAssignment;
    }

    public List<AssignmentHistory> getHistoryByTicketId(Long ticketId) {
        return assignmentHistoryRepository.findByTicketId(ticketId);
    }

    public void deleteAssignment(Long id) {
        Assignment assignment = assignmentRepository.findById(id)
                .orElseThrow(() -> new AssignmentNotFoundException("Assignment with id " + id + " not found"));

        assignmentRepository.delete(assignment);
    }
}