package com.pmf.rzk.activityservice.controller;

import com.pmf.rzk.activityservice.model.Attachment;
import com.pmf.rzk.activityservice.service.AttachmentService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Validated
@RestController
public class AttachmentController {

    private final AttachmentService attachmentService;

    public AttachmentController(AttachmentService attachmentService) {
        this.attachmentService = attachmentService;
    }

    @GetMapping("/attachments")
    public List<Attachment> getAllAttachments() {
        return attachmentService.getAllAttachments();
    }

    @GetMapping("/attachments/{id}")
    public Attachment getAttachmentById(@PathVariable @Min(1) Long id) {
        return attachmentService.getAttachmentById(id);
    }

    @GetMapping("/attachments/ticket/{ticketId}")
    public List<Attachment> getAttachmentsByTicketId(@PathVariable @Min(1) Long ticketId) {
        return attachmentService.getAttachmentsByTicketId(ticketId);
    }

    @PostMapping("/attachments")
    public Attachment createAttachment(@Valid @RequestBody Attachment attachment) {
        return attachmentService.createAttachment(attachment);
    }

    @DeleteMapping("/attachments/{id}")
    public void deleteAttachment(@PathVariable @Min(1) Long id) {
        attachmentService.deleteAttachment(id);
    }
}