package com.mycompany.myproject.service.svc;


import java.sql.Date;

public interface RatesService{
    float getRateAgeByUser(Long userId);
    float getRateAgeByBirthday(Date birthday);
    float getRateDaysBeforeByTravelDate(Date travelDate);
    float getRateSeasonByDate(Date travelDate);
    float getRateSeatsLeft(int occupiedSeats, int totalSeats);
    float calculateTotalRate(Date birthday, Date travelDate, int occupiedSeats, int totalSeats);
}
