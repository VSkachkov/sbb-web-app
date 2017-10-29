package com.mycompany.myproject.dao.api;

import com.mycompany.myproject.persist.entity.RateSeason;

import java.util.List;

public interface RateSeasonDao {
    public List<RateSeason> getAllSeasonRates();
    public float getSeasonRateByDay(int dayNumber);
}
