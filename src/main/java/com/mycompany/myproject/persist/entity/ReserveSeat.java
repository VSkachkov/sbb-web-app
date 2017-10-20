package com.mycompany.myproject.persist.entity;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.sql.Date;

@ToString
@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "Reserve_Seats", schema = "SBB_DB")
public class ReserveSeat {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Run_id")
    private Long runId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "timetable_id")
    private Timetable timetableId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "User_id")
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TrainNumber")
    private Train train;

    @Basic
    @Column(name = "Travel_date")
    private Date travelDate;
}
