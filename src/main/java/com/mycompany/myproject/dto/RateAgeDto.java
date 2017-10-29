package com.mycompany.myproject.dto;

import com.mycompany.myproject.persist.entity.RateAge;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RateAgeDto {
    private Long ageRateId;
    private int ageLow;
    private int ageHigh;
    private float ageRate;

    public RateAgeDto() {
    }

    public RateAgeDto(Long ageRateId, int ageLow, int ageHigh, float ageRate) {
        this.ageRateId = ageRateId;
        this.ageLow = ageLow;
        this.ageHigh = ageHigh;
        this.ageRate = ageRate;
    }

    public RateAgeDto(RateAge rateAge){
        this.ageRateId = rateAge.getAgeRateId();
        this.ageLow = rateAge.getAgeLow();
        this.ageHigh = rateAge.getAgeHigh();
        this.ageRate = rateAge.getAgeRate();
    }
}
