package com.mycompany.myproject.service.svc;


import com.mycompany.myproject.dto.RateAgeDto;
import com.mycompany.myproject.dto.RateSeasonDto;
import com.mycompany.myproject.persist.entity.RateDaysBefore;
import com.mycompany.myproject.persist.entity.RateSeatsLeft;

import java.sql.Date;
import java.util.List;

public interface RatesService {
    /**
     * gets rate by user ID
     *
     * @param userId user ID
     * @return rate
     */
    float getRateAgeByUser(Long userId);

    /**
     * provides all age rates
     * @return DTO age rates
     */
    List<RateAgeDto> getAllAgeRates();

    /**
     * gets all season rates
     * @return DTO season rates
     */
    List<RateSeasonDto> getAllSeasonRates();

    /**
     * provides all date before buy rates
     * @return rate enitities
     */
    List<RateDaysBefore> getAllDaysBeforeRates();

    /**
     * provides seats left rates
     * @return seats left rates
     */
    List<RateSeatsLeft> getAllSeatsLeftRates();

    /**
     * calculates age rate by birthday
     * @param birthday
     * @return rate
     */
    float getRateAgeByBirthday(Date birthday);

    /**
     * calculates rate based on travel date and current date
     * @param travelDate
     * @return
     */
    float getRateDaysBeforeByTravelDate(Date travelDate);

    /**
     * calculates season rate by travel date
     * @param travelDate
     * @return rate
     */
    float getRateSeasonByDate(Date travelDate);

    /**
     * calculates rate considering total and occupied number of seats
     * @param occupiedSeats occupied nuumber
     * @param totalSeats total seats
     * @return rate
     */
    float getRateSeatsLeft(Long occupiedSeats, Long totalSeats);

    /**
     * calculates total rates
     * @param birthday birthday
     * @param travelDate travel date
     * @param occupiedSeats
     * @param totalSeats
     * @return rate
     */
    float calculateTotalRate(Date birthday, Date travelDate, Long occupiedSeats, Long totalSeats);

    /**
     * provides statndart age rate to calculate standard price
     * @return
     */
    float getHighestAgeRate();

    /**
     * calculate standard price rate for params
     * @param travelDate travel date
     * @param occupiedSeats
     * @param totalSeats
     * @return rate
     */
    float calculateStandardRate(Date travelDate, Long occupiedSeats, Long totalSeats);

    /**
     * calculates total rate taking into account all 4 rates
     * @param rateAge
     * @param rateSeason
     * @param rateBuyBefore
     * @param rateOccupancy
     * @return
     */
    float calculateFormula(float rateAge, float rateSeason, float rateBuyBefore, float rateOccupancy);
}
