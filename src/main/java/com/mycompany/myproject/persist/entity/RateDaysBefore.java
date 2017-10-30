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
@Table(name = "days_before_rate", schema = "SBB_DB")
@Check(constraints = "days_low <= days_high")
public class RateDaysBefore implements Serializable {

        @Id
        @GenericGenerator(name = "generator", strategy = "increment")
        @GeneratedValue(generator = "generator")
        @Column(name = "days_before_id")
        private Long daysBerforeId;

        @Basic
        @Column (name = "days_low")
        private int daysBeforeLow;

        @Basic
        @Column (name = "days_high")
        private int daysBeforeHigh;

        @Basic
        @Column (name = "days_before_rate")
        private float daysBeforeRate;

    }
