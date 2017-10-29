package com.mycompany.myproject.dao.api;

import com.mycompany.myproject.persist.entity.RateSeatsLeft;

import java.util.List;

public interface RateSeatsLeftDao {
     List<RateSeatsLeft> getAllSeatsLeftRates();
     float getSeatsLeftRateByOccupancy(float occupancy);
}
