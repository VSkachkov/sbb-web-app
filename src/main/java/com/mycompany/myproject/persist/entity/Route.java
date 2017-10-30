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
@Table(name = "Routes", schema = "SBB_DB")
public class Route implements Serializable {
    @Id
    @Column(name = "Route_id", nullable = false)
    @GenericGenerator(name = "generator", strategy = "increment")
    @GeneratedValue(generator = "generator")
    private long routeId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Section_id")
    private Section section;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "train_number")
    private Train train;

    @Basic
    @Column (name = "Departure")
    private Time departure;


    @Basic
    @Column (name = "Arrival")
    private Time arrival;


}
