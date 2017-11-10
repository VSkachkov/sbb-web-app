package com.mycompany.myproject.persist.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Time;

@ToString
@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "Train_changes", schema = "SBB_DB")
public class TrainChange {
    @Id
    @Column(name = "change_id", nullable = false)
    @GenericGenerator(name = "generator", strategy = "increment")
    @GeneratedValue(generator = "generator")
    private long changeId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "trainNumber")
    private Train train;

    @Basic
    @Column(name = "TravelDate")
    private Date travelDate;

    @Basic
    @Column(name = "Status")
    private String status;

    @Basic
    @Column (name = "Delay")
    private Time delayTime;
}
