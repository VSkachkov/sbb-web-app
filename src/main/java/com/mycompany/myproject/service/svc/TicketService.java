package com.mycompany.myproject.service.svc;

import com.mycompany.myproject.dto.PassengerForm;

public interface TicketService {

    /**
     * launches procedure of ticket buying
     * @param passengerForm contains information about travelling details
     * @return result information
     */
    String launchBuyingProcedure(PassengerForm passengerForm);
}
