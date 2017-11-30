package com.mycompany.myproject.service.svc;

import com.mycompany.myproject.dto.PassengerForm;
import com.mycompany.myproject.dto.TicketWebDto;

import java.sql.Date;

public interface TicketService {

    /**
     * checks if there is enough time bbefore departture
     *
     * @param trainId   train id
     * @param stationId station of departure
     * @return true if ok
     */
    boolean checkEnoughTimeBeforeDeparture(Long trainId, Long stationId);

    /**
     * checks if there is train following on this date
     * @param travelDate date
     * @return true if ok
     */
    boolean checkDateValidity(Date travelDate);

    /**
     * true if buying procedure was successful
     * @param ticketWebDto
     * @return
     */
    boolean buyWebTicket(TicketWebDto ticketWebDto);


}
