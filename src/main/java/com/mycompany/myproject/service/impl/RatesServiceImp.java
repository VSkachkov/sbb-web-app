package com.mycompany.myproject.service.impl;

import com.mycompany.myproject.dao.api.RateAgeDao;
import com.mycompany.myproject.dao.api.RateDaysBeforeDao;
import com.mycompany.myproject.dao.api.RateSeasonDao;
import com.mycompany.myproject.dao.api.RateSeatsLeftDao;
import com.mycompany.myproject.dto.RateAgeDto;
import com.mycompany.myproject.dto.RateSeasonDto;
import com.mycompany.myproject.dto.UserDto;
import com.mycompany.myproject.persist.entity.*;
import com.mycompany.myproject.service.svc.RatesService;
import com.mycompany.myproject.service.svc.UserService;
import org.joda.time.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;


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
    public float getRateAgeByUser(Long userId) {
        User user = userService.getUserById(userId);
        UserDto userDto = new UserDto(user);
        Date bday = userDto.getBirthday();
        return this.getRateAgeByBirthday(bday);
    }

    @Override
    public List<RateAgeDto> getAllAgeRates() {
        List<RateAge> ageRates = rateAgeDao.getAllAgeRates();
        List<RateAgeDto> ageRateDtos = new ArrayList<>();
        for (RateAge rateAge :
                ageRates) {
            ageRateDtos.add(new RateAgeDto(rateAge));
        }
        return ageRateDtos;
    }

    @Override
    public List<RateSeasonDto> getAllSeasonRates() {
        List<RateSeasonDto> rateSeasonDtoList = new ArrayList<>();
        for (RateSeason rateSeason :
                rateSeasonDao.getAllSeasonRates()) {
            rateSeasonDtoList.add(new RateSeasonDto(rateSeason));
        }
        return rateSeasonDtoList;
    }

    @Override
    public List<RateDaysBefore> getAllDaysBeforeRates() {
        return rateDaysBeforeDao.getAllRatesDaysBefore();
    }

    @Override
    public List<RateSeatsLeft> getAllSeatsLeftRates() {
        return rateSeatsLeftDao.getAllSeatsLeftRates();
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
    public float getHighestAgeRate() {
        float highestAgeRate = 0;
        List<RateAge> rateAges = rateAgeDao.getAllAgeRates();
        for (RateAge rate :
                rateAges) {
            if (rate.getAgeRate() > highestAgeRate)
                highestAgeRate = rate.getAgeRate();
        }
        return highestAgeRate;
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
    public float getRateSeasonByDate(Date travelDate) {
        LocalDate travelLocalDate = new LocalDate(travelDate);
        int dayOfYear = travelLocalDate.getDayOfYear();
        return rateSeasonDao.getSeasonRateByDay(dayOfYear);

    }

    @Override
    public float getRateSeatsLeft(Long occupiedSeats, Long totalSeats) {
        float occupied = (float) occupiedSeats;
        float occupancy = occupied / totalSeats;
        return rateSeatsLeftDao.getSeatsLeftRateByOccupancy(occupancy);

    }

    @Override
    public float calculateStandardRate(Date travelDate, Long occupiedSeats, Long totalSeats) {
        float rateAge = getHighestAgeRate();
        float rateSeason = this.getRateSeasonByDate(travelDate);
        float rateBuyBefore = this.getRateDaysBeforeByTravelDate(travelDate);
        float rateOccupancy = this.getRateSeatsLeft(occupiedSeats, totalSeats);
        return calculateFormula(rateAge, rateSeason, rateOccupancy, rateBuyBefore);
    }

    @Override
    public float calculateTotalRate(Date birthday, Date travelDate, Long occupiedSeats, Long totalSeats) {
        float rateAge = this.getRateAgeByBirthday(birthday);
        float rateSeason = this.getRateSeasonByDate(travelDate);
        float rateBuyBefore = this.getRateDaysBeforeByTravelDate(travelDate);
        float rateOccupancy = this.getRateSeatsLeft(occupiedSeats, totalSeats);
        return calculateFormula(rateAge, rateSeason, rateBuyBefore, rateOccupancy);

    }

    @Override
    public float calculateFormula(float rateAge, float rateSeason, float rateBuyBefore, float rateOccupancy) {
        return rateAge * rateSeason * rateBuyBefore * rateOccupancy / 4;
    }
}
