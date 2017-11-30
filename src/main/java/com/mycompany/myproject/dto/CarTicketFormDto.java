package com.mycompany.myproject.dto;

import com.mycompany.myproject.persist.entity.Car;
import lombok.Data;

@Data
public class CarTicketFormDto {
    private Long carId;
    private String carName;
    private Long seatsNumber;
    private Long numberOfCars;
    private Long occupiedSeats;
    private Long totalSeatsNumber;
    private float carPriceRate;
    private float standardPrice;

    public CarTicketFormDto() {
    }

    public CarTicketFormDto(CarDto carDto) {
        this.carId = carDto.getCarId();
        this.carName = carDto.getCarName();
        this.seatsNumber = carDto.getSeatsNumber();
        this.carPriceRate = carDto.getCarPriceRate();
    }

    public CarTicketFormDto(Car car){
        this.carId = car.getCarId();
        this.carName = car.getCarName();
        this.seatsNumber = car.getSeatsNumber();
        this.carPriceRate = car.getCarPriceRate();
    }
}
