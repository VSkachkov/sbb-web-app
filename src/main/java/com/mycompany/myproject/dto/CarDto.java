package com.mycompany.myproject.dto;

import com.mycompany.myproject.persist.entity.Canton;
import com.mycompany.myproject.persist.entity.Car;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CarDto {

    private Long carId;
    private String carName;
    private Long seatsNumber;
    private float carPriceRate;

    public CarDto(Car car) {
        this.carId = car.getCarId();
        this.carName = car.getCarName();
        this.seatsNumber = car.getSeatsNumber();
        this.carPriceRate = car.getCarPriceRate();

    }

    public CarDto(){

    }

    public Long getCarId() {
        return carId;
    }

    public void setCarId(Long carId) {
        this.carId = carId;
    }

    public String getCarName() {
        return carName;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public Long getSeatsNumber() {
        return seatsNumber;
    }

    public void setSeatsNumber(Long seatsNumber) {
        this.seatsNumber = seatsNumber;
    }

    public float getCarPriceRate() {
        return carPriceRate;
    }

    public void setCarPriceRate(float carPriceRate) {
        this.carPriceRate = carPriceRate;
    }
}
