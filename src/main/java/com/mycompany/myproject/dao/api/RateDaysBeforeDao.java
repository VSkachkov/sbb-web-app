package com.mycompany.myproject.dao.api;

import com.mycompany.myproject.persist.entity.RateDaysBefore;

import java.util.List;

public interface RateDaysBeforeDao {
    List<RateDaysBefore> getAllRatesDaysBefore();
    void addNewRateDaysBefore(RateDaysBefore rateDaysBefore);
    void removeRateDaysBefore(Long rateId);
    float getRateDaysBeforeByDays(int daysBeforeDeparture);
}
