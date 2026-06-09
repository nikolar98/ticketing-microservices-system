package com.pmf.rzk.activityservice.service;

import com.pmf.rzk.activityservice.exception.AttachmentNotFoundException;
import com.pmf.rzk.activityservice.model.Attachment;
import com.pmf.rzk.activityservice.repository.AttachmentRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class AttachmentService {

    private final AttachmentRepository attachmentRepository;

    public AttachmentService(AttachmentRepository attachmentRepository) {
        this.attachmentRepository = attachmentRepository;
    }

    public List<Attachment> getAllAttachments() {
        return attachmentRepository.findAll();
    }

    public Attachment getAttachmentById(Long id) {
        return attachmentRepository.findById(id)
                .orElseThrow(() -> new AttachmentNotFoundException("Attachment with id " + id + " not found"));
    }

    public List<Attachment> getAttachmentsByTicketId(Long ticketId) {
        return attachmentRepository.findByTicketId(ticketId);
    }

    public Attachment createAttachment(Attachment attachment) {
        attachment.setUploadedAt(Instant.now());
        return attachmentRepository.save(attachment);
    }

    public void deleteAttachment(Long id) {
        Attachment attachment = attachmentRepository.findById(id)
                .orElseThrow(() -> new AttachmentNotFoundException("Attachment with id " + id + " not found"));

        attachmentRepository.delete(attachment);
    }
}