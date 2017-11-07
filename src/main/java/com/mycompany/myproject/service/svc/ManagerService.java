package com.mycompany.myproject.service.svc;

import com.mycompany.myproject.dto.*;
import com.mycompany.myproject.persist.entity.TrainType;

import java.sql.Date;
import java.util.List;

public interface ManagerService {

    /**
     * fills list of train DTO with data about arrival, departure time and stations
     * @return List of DTO objects
     */
    public List<TrainDto> getTrainsForManagers();

    /**
     * adds train DTO object to database
     * @param trainDto trainDTO obeject
     */
    void addTrainToDB(TrainDto trainDto);

    /**
     * extracts list of canton names from database
     * @return list of canton names
     */
    List<String> getCantonNames();

    /**
     * adds station to database with data from StationForm
     * @param stationForm
     */
    void addStationToDB(StationForm stationForm);

    /**
     * provides list of passengers for specific train and date
     * @param trainNumber train Number in DB
     * @param travelDate date of travel
     * @return list of passengers in Passenger Form
     */
    List<PassengerForm> getPassengers(Long trainNumber, Date travelDate);

    /**
     * extracts list of canton names from database
     * @return List of cantons names
     */
    List<String> getAllCantonsNames();

    void addRouteToDB(RouteDto routeDto);

    void addSectionToDB(SectionDto sectionDto);

    void addCarToDB(CarDto carDto);

    void addTrainType(TrainTypeDto trainTypeDto);
}
