package com.mycompany.myproject.persist.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Check;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@ToString
@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "seats_left_rate", schema = "SBB_DB")
@Check(constraints = "seats_left_low <= seats_left_high")
public class RateSeatsLeft implements Serializable {


    @Id
    @GenericGenerator(name = "generator", strategy = "increment")
    @GeneratedValue(generator = "generator")
    @Column(name = "seat_left_id")
    private Long seatsLeftId;

    @Basic
    @Column (name = "seats_left_low")
    private float seatsLeftLow;

    @Basic
    @Column (name = "seats_left_high")
    private float seatsLeftHigh;

    @Basic
    @Column (name = "seats_left_rate")
    private float seatsLeftRate;


}
