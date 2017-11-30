package com.mycompany.myproject.service.svc;


import com.mycompany.myproject.dto.RateAgeDto;
import com.mycompany.myproject.dto.RateSeasonDto;
import com.mycompany.myproject.persist.entity.RateDaysBefore;
import com.mycompany.myproject.persist.entity.RateSeatsLeft;

import java.sql.Date;
import java.util.List;

public interface RatesService{
    float getRateAgeByUser(Long userId);
    List<RateAgeDto> getAllAgeRates();
    List<RateSeasonDto> getAllSeasonRates();
    List<RateDaysBefore> getAllDaysBeforeRates();
    List<RateSeatsLeft> getAllSeatsLeftRates();
    float getRateAgeByBirthday(Date birthday);
    float getRateDaysBeforeByTravelDate(Date travelDate);
    float getRateSeasonByDate(Date travelDate);
    float getRateSeatsLeft(Long occupiedSeats, Long totalSeats);
    float calculateTotalRate(Date birthday, Date travelDate, Long occupiedSeats, Long totalSeats);
    float getHighestAgeRate();
    float calculateStandardRate(Date travelDate, Long occupiedSeats, Long totalSeats);
    float calculateFormula(float rateAge, float rateSeason, float rateBuyBefore, float rateOccupancy);
}
