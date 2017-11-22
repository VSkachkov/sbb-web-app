package com.mycompany.myproject.dto;

import com.mycompany.myproject.persist.entity.RateSeason;
import lombok.Data;

@Data
public class RateSeasonDto {
    private Long seasonRateId;
    private int dateLow;
    private float seasonRate;

    public RateSeasonDto(RateSeason rateSeason) {
        this.seasonRateId = rateSeason.getSeasonRateId();
        this.dateLow = rateSeason.getDateLow();
        this.seasonRate = rateSeason.getSeasonRate();
    }

    public RateSeasonDto(Long seasonRateId, int dateLow, float seasonRate) {
        this.seasonRateId = seasonRateId;
        this.dateLow = dateLow;
        this.seasonRate = seasonRate;
    }

    public RateSeasonDto() {
    }
}
