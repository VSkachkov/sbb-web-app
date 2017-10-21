package com.mycompany.myproject.persist.entity;


import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

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
    @GenericGenerator(name = "generator", strategy = "increment")
    @GeneratedValue(generator = "generator")
    @Column(name = "reserve_id")
    private Long runId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "station_id")
    private Station stationId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "User_id")
    private User userId;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "TrainNumber")
    private Train trainId;

    @Basic
    @Column(name = "Travel_date")
    private Date travelDate;
}
