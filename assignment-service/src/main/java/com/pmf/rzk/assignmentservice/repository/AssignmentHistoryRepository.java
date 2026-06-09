package com.pmf.rzk.assignmentservice.repository;

import com.pmf.rzk.assignmentservice.model.AssignmentHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AssignmentHistoryRepository extends JpaRepository<AssignmentHistory,Long> {
    List<AssignmentHistory> findByTicketId(Long ticketId);
}
