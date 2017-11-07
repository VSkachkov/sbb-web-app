package com.mycompany.myproject.dao.api;

import com.mycompany.myproject.persist.entity.RateSeason;

import java.util.List;

public interface RateSeasonDao {
    List<RateSeason> getAllSeasonRates();
    float getSeasonRateByDay(int dayNumber);
    void addNewSeasonRate(RateSeason rateSeason);
}
