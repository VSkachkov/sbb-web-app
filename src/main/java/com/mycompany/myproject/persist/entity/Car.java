package com.mycompany.myproject.persist.entity;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@ToString
@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "Carriages", schema = "SBB_DB")
public class Car {
    @Id
    @GenericGenerator(name = "generator", strategy = "increment")
    @GeneratedValue(generator = "generator")
    @Column(name = "car_id")
    private Long carId;



    @Basic
    @Column(name = "car_name")
    private String carName;

    @Basic
    @Column (name = "seats")
    private Long seatsNumber;

    @Basic
    @Column (name="Car_price_rate")
    private float carPriceRate;

}
