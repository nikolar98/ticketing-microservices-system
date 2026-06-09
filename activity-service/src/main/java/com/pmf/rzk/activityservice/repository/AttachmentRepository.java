package com.pmf.rzk.activityservice.repository;

import com.pmf.rzk.activityservice.model.Attachment;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AttachmentRepository extends JpaRepository<Attachment,Long> {
    List<Attachment> findByTicketId(Long ticketId);
}
