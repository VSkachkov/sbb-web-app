package com.mycompany.myproject.persist.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.Check;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@ToString
@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "age_rate", schema = "SBB_DB")
@Check(constraints = "age_low <= age_high")
public class RateAge {
    @Id
    @GenericGenerator(name = "generator", strategy = "increment")
    @GeneratedValue(generator = "generator")
    @Column(name = "age_rate_id")
    private Long ageRateId;

    @Basic
    @Column (name = "age_low")
    private int ageLow;

    @Basic
    @Column (name = "age_high")
    private int ageHigh;

    @Basic
    @Column (name = "age_rate")
    private float ageRate;

}
