package com.pmf.rzk.activityservice.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
@Entity
@Table(name = "attachments", schema = "nr_activity_db")
public class Attachment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @NotNull(message = "Ticket id is required")
    @Column(name = "ticket_id")
    private Long ticketId;

    @NotBlank(message = "File name is required")
    @Size(max = 255, message = "File name should not be longer than 255 characters")
    @Column(name = "file_name")
    private String fileName;

    @NotBlank(message = "File path is required")
    @Size(max = 255, message = "File path should not be longer than 255 characters")
    @Column(name = "file_path")
    private String filePath;

    @Column(name = "uploaded_at")
    private Instant uploadedAt;

}