package com.pmf.rzk.ticketservice.repository;

import com.pmf.rzk.ticketservice.model.TicketStatusHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TicketStatusHistoryRepository extends JpaRepository<TicketStatusHistory, Long>
{

}
