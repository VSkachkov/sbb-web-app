package com.mycompany.myproject.service.impl;


import com.mycompany.myproject.persist.entity.Ticket;
import com.mycompany.myproject.service.dao.api.TicketDao;
import com.mycompany.myproject.service.svc.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class TicketServiceImp implements  TicketService {

    @Autowired
    TicketDao ticketDao;

    @Override
    public List<Ticket> getAllTickets() {
        return ticketDao.getAllTickets();
    }

    @Override
    public void addNewTicket(Ticket ticket) {
        ticketDao.addNewTicket(ticket);

    }
}
