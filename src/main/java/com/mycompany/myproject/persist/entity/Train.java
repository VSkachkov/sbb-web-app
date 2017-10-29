package com.mycompany.myproject.persist.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;



@ToString
@Getter
@Setter
@EqualsAndHashCode
@Entity // This tells Hibernate to make a table out of this class
@Table (name = "Trains")
public class Train  implements Serializable {

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


    @ManyToOne
    @JoinColumn(name = "train_types_number_id")
    private TrainTypeNumber trainTypeNumber;

//    @ManyToOne(fetch = FetchType.LAZY)
////    @JoinColumn(name = "Train_type_id")
////    @Embedded
////    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumns({
//            @JoinColumn(name = "Train_type_id", referencedColumnName = "Train_type_id"),
//            @JoinColumn(name ="car_id", referencedColumnName = "Car")
//    })
//    private TrainType trainType;


}
