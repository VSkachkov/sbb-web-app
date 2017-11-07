package com.mycompany.myproject.service.impl;

import com.mycompany.myproject.dao.api.RateAgeDao;
import com.mycompany.myproject.dao.api.RateDaysBeforeDao;
import com.mycompany.myproject.dao.api.RateSeasonDao;
import com.mycompany.myproject.dao.api.RateSeatsLeftDao;
import com.mycompany.myproject.dto.UserDto;
import com.mycompany.myproject.persist.entity.RateAge;
import com.mycompany.myproject.persist.entity.RateSeatsLeft;
import com.mycompany.myproject.persist.entity.User;
import com.mycompany.myproject.service.svc.RatesService;
import com.mycompany.myproject.service.svc.UserService;
import org.joda.time.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;


@Service
@Transactional
public class RatesServiceImp implements RatesService {

    @Autowired
    UserService userService;

    @Autowired
    RateAgeDao rateAgeDao;

    @Autowired
    RateDaysBeforeDao rateDaysBeforeDao;

    @Autowired
    RateSeasonDao rateSeasonDao;

    @Autowired
    RateSeatsLeftDao rateSeatsLeftDao;

    @Override
    public float getRateAgeByUser(Long userId){
        User user = userService.getUserById(userId);
        UserDto userDto = new UserDto(user);
        Date bday = userDto.getBirthday();
        return this.getRateAgeByBirthday(bday);
    }

    @Override
    public float getRateAgeByBirthday(Date birthday) {
        LocalDate birthdate = new LocalDate(birthday);
        LocalDate now = new LocalDate();
        Years age = Years.yearsBetween(birthdate, now);
        int ageInt = age.getYears();
        return rateAgeDao.getAgeRateByAge(ageInt);
    }

    @Override
    public float getRateDaysBeforeByTravelDate(Date travelDate) {
        LocalDate travelLocalDate = new LocalDate(travelDate);
        LocalDate now = new LocalDate();
        Days daysDifference = Days.daysBetween(now, travelLocalDate);
        int daysInt = daysDifference.getDays();
        return rateDaysBeforeDao.getRateDaysBeforeByDays(daysInt);
    }

    @Override
    public float getRateSeasonByDate(Date travelDate){
        LocalDate travelLocalDate = new LocalDate(travelDate);
        int dayOfYear = travelLocalDate.getDayOfYear();
        return rateSeasonDao.getSeasonRateByDay(dayOfYear);

    }

    @Override
    public float getRateSeatsLeft(int occupiedSeats, int totalSeats) {
        float occupied = (float) occupiedSeats;
        float occupancy = occupied/totalSeats;
        return rateSeatsLeftDao.getSeatsLeftRateByOccupancy(occupancy);

    }

    @Override
    public float calculateTotalRate(Date birthday, Date travelDate, int occupiedSeats, int totalSeats) {
        float rateAge = this.getRateAgeByBirthday(birthday);
        float rateSeason = this.getRateSeasonByDate(travelDate);
        float rateBuyBefore = this.getRateDaysBeforeByTravelDate(travelDate);
        float rateOccupancy = this.getRateSeatsLeft(occupiedSeats, totalSeats);

        float rateTotal = (rateAge+rateSeason+rateBuyBefore+rateOccupancy)/4;
        return rateTotal;
    }
}
