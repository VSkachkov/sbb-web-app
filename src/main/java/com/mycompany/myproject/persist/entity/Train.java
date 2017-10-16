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
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column (name = "trainNumber")
    private Long trainNumber;

    @Column (name = "Train_name")
    private String TrainName;

    @Column (name = "Depart_MON")
    private boolean departMon;

    @Column (name = "Depart_TUE")
    private boolean departTue;

    @Column (name = "Depart_WED")
    private boolean departWed;

    @Column (name = "Depart_THU")
    private boolean departThu;

    @Column (name = "Depart_FRI")
    private boolean departFri;

    @Column (name = "Depart_SAT")
    private boolean departSat;

    @Column (name = "Depart_SUN")
    private boolean departSun;

    @Column (name = "train_type_id")
    private Long trainTypeId;


}
