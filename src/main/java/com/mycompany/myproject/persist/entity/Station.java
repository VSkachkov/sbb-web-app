package com.mycompany.myproject.persist.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;

@ToString
@Getter
@Setter
@EqualsAndHashCode
@Entity // This tells Hibernate to make a table out of this class
@Table (name = "Stations", schema = "SBB_DB")
public class Station implements Serializable {
    @Id
    @GenericGenerator(name = "generator", strategy = "increment")
    @GeneratedValue(generator = "generator")
    @Column (name = "station_id")
    private Long stationId;

    @Basic
    @Column(name = "station_name")
    private String stationName;

//
//    @Basic
//    @Column (name = "is_Node")
//    private boolean node;

//    @ManyToOne(cascade = CascadeType.MERGE)
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "canton_id")
    private Canton canton;




}
