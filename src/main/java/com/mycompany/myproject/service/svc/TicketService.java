package com.mycompany.myproject.service.svc;

import com.mycompany.myproject.dto.PassengerForm;
import com.mycompany.myproject.dto.TicketWebDto;

import java.sql.Date;

public interface TicketService {

    /**
     * launches procedure of ticket buying
     * @param passengerForm contains information about travelling details
     * @return result information
     */
    String launchBuyingProcedure(PassengerForm passengerForm);
    String launchUpdatedBuyProcedure(PassengerForm passengerForm);
    boolean checkEnoughTimeBeforeDeparture(Long trainId, Long stationId);
    boolean checkDateValidity(Date travelDate);
    boolean buyWebTicket(TicketWebDto ticketWebDto);


}
