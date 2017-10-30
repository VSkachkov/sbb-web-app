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
@Table(name = "season_rates", schema = "SBB_DB")
@Check(constraints = "date_low <= date_high")
public class RateSeason  implements Serializable {

    @Id
    @GenericGenerator(name = "generator", strategy = "increment")
    @GeneratedValue(generator = "generator")
    @Column(name = "season_rate_id")
    private Long seasonRateId;

    @Basic
    @Column (name = "date_low")
    private int dateLow;

    @Basic
    @Column (name = "date_high")
    private int dateHigh;

    @Basic
    @Column (name = "season_rate")
    private float seasonRate;
}
