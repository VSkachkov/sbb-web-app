package com.mycompany.myproject.service.dao.api;

import com.mycompany.myproject.persist.entity.Ticket;

import java.util.List;

public interface TicketDao {
    List<Ticket> getAllTickets();
    void addNewTicket(Ticket ticket);
}
