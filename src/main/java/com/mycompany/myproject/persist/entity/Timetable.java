package com.mycompany.myproject.persist.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Time;


@ToString
@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "Timetable", uniqueConstraints =
@UniqueConstraint(columnNames={"trainNumber", "station_id"}))

public class Timetable implements Serializable{


//    @Id
//    @Column(name = "trainNumber", nullable = false)
//    private Long trainNumber;
//
//    @Id
//    @Column (name = "station_id", nullable = false)
//    private Long station_id;
//
@Id
@GenericGenerator(name = "generator", strategy = "increment")
@GeneratedValue(generator = "generator")
@Column (name = "timetable_id")
private Long timetableId;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "trainNumber", nullable = false)
    private Train train;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "station_id", nullable = false)
    private Station station;

    @Column (name = "departure")
    private Time departure;

    @Column (name = "arrival")
    private Time arrival;
}
