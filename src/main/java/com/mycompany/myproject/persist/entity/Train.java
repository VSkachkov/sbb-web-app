package com.mycompany.myproject.persist.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;



@ToString
@Getter
@Setter
@EqualsAndHashCode
@Entity // This tells Hibernate to make a table out of this class
@Table (name = "Trains")
public class Train {

    @Id
    @GenericGenerator(name = "generator", strategy = "increment")
    @GeneratedValue(generator = "generator")
    @Column (name = "trainNumber")
    private Long trainId;

    @Basic
    @Column (name = "Train_name")
    private String TrainName;

    @Basic
    @Column (name = "Depart_MON")
    private boolean departMon;

    @Basic
    @Column (name = "Depart_TUE")
    private boolean departTue;

    @Basic
    @Column (name = "Depart_WED")
    private boolean departWed;

    @Basic
    @Column (name = "Depart_THU")
    private boolean departThu;

    @Basic
    @Column (name = "Depart_FRI")
    private boolean departFri;

    @Basic
    @Column (name = "Depart_SAT")
    private boolean departSat;

    @Basic
    @Column (name = "Depart_SUN")
    private boolean departSun;

    @Basic
    @Column (name = "capacity")
    private Long capacity;


}
