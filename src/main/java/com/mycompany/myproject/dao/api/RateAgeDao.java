package com.mycompany.myproject.dao.api;

import com.mycompany.myproject.persist.entity.RateAge;


import java.util.List;

public interface RateAgeDao {
    List<RateAge> getAllAgeRates();
    void addNewRateAge(RateAge rateAge);
    void removeRateAge(Long rateId);

    float getAgeRateByAge(int ageInt);
}
