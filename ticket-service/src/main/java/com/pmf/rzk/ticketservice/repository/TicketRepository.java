package com.pmf.rzk.ticketservice.repository;

import com.pmf.rzk.ticketservice.model.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketRepository extends JpaRepository<Ticket, Long> {

}
