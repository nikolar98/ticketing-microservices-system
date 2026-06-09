package com.pmf.rzk.ticketservice.controller;

import com.pmf.rzk.ticketservice.model.Ticket;
import com.pmf.rzk.ticketservice.service.TicketService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Min;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Validated
public class TicketController {

    private final TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    @GetMapping("/tickets")
    public List<Ticket> getAllTickets() {
        return ticketService.getAllTickets();
    }

    @GetMapping("/tickets/{id}")
    public Ticket getTicketById(@PathVariable @Min(1) Long id) {
        return ticketService.getTicketById(id);
    }

    @PostMapping("/tickets")
    public Ticket createTicket(@Valid @RequestBody Ticket ticket) {
        return ticketService.createTicket(ticket);
    }

    @DeleteMapping("/tickets/{id}")
    public void deleteTicket(@PathVariable @Min(1) Long id) {
        ticketService.deleteTicket(id);
    }


    @PutMapping("/tickets/{id}/status/{status}")
    public Ticket updateTicketStatus(
            @PathVariable @Min(1) Long id,
            @PathVariable String status) {

        return ticketService.updateTicketStatus(id, status);
    }
}