package com.mycompany.myproject.service.svc;

import com.mycompany.myproject.persist.entity.Ticket;
import com.mycompany.myproject.service.dto.PassengerForm;

import java.util.List;

public interface TicketService {

    List<Ticket> getAllTickets();
    void addNewTicket(Ticket ticket);

    String launchBuyingProcedure(PassengerForm passengerForm);
}
