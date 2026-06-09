package com.pmf.rzk.assignmentservice.dto;

import lombok.Getter;

@Getter
public class NotificationRequest {

    private Long ticketId;
    private Long recipientId;
    private String message;

    public NotificationRequest() {
    }

    public NotificationRequest(Long ticketId, Long recipientId, String message) {
        this.ticketId = ticketId;
        this.recipientId = recipientId;
        this.message = message;
    }

    public void setTicketId(Long ticketId) {
        this.ticketId = ticketId;
    }

    public void setRecipientId(Long recipientId) {
        this.recipientId = recipientId;
    }

    public void setMessage(String message) {
        this.message = message;
    }


}