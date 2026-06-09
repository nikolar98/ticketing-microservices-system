package com.pmf.rzk.ticketservice.service;

import com.pmf.rzk.ticketservice.exception.TicketNotFoundException;
import com.pmf.rzk.ticketservice.model.Ticket;
import com.pmf.rzk.ticketservice.repository.TicketRepository;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;

@Service
public class TicketService {

    private final TicketRepository ticketRepository;


    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public List<Ticket> getAllTickets() {
        return ticketRepository.findAll();
    }

    public Ticket getTicketById(Long id) {
        return ticketRepository.findById(id)
                .orElseThrow(() -> new TicketNotFoundException("Ticket with id " + id + " not found"));
    }

    public Ticket createTicket(Ticket ticket) {
        ticket.setId(null);
        ticket.setCreatedAt(Instant.now());
        ticket.setUpdatedAt(Instant.now());

        if (ticket.getStatus() == null || ticket.getStatus().isBlank()) {
            ticket.setStatus("OPEN");
        }

        if (ticket.getPriority() == null || ticket.getPriority().isBlank()) {
            ticket.setPriority("MEDIUM");
        }

        if (ticket.getType() == null || ticket.getType().isBlank()) {
            ticket.setType("TASK");
        }

        return ticketRepository.save(ticket);
    }

    public void deleteTicket(Long id) {
        Ticket ticket = ticketRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Ticket with id " + id + " not found"));

        ticketRepository.delete(ticket);
    }

    public Ticket updateTicketStatus(Long id, String status) {

        Ticket ticket = ticketRepository.findById(id)
                .orElseThrow(() -> new TicketNotFoundException("Ticket with id " + id + " not found"));

        ticket.setStatus(status.toUpperCase());
        ticket.setUpdatedAt(Instant.now());

        return ticketRepository.save(ticket);
    }

}