package com.mycompany.myproject.service.svc;

import com.mycompany.myproject.dto.PassengerForm;
import com.mycompany.myproject.dto.TicketWebDto;

import java.sql.Date;

public interface TicketService {

    boolean checkEnoughTimeBeforeDeparture(Long trainId, Long stationId);
    boolean checkDateValidity(Date travelDate);
    boolean buyWebTicket(TicketWebDto ticketWebDto);


}
