package com.pmf.rzk.ticketservice.exception;

public class TicketNotFoundException extends RuntimeException {
    public TicketNotFoundException(String message) {

        super(message);
    }
}
