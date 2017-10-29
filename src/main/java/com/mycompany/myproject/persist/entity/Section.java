package com.mycompany.myproject.persist.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;

@ToString
@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "Sections", schema = "SBB_DB")
public class Section {

    @Id
    @GenericGenerator(name = "generator", strategy = "increment")
    @GeneratedValue(generator = "generator")
    @Column(name = "section_id")
    private Long sectionId;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "station_from_id")
    private Station stationFromId;


    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "station_to_id")
    private Station stationToId;

    @Basic
    @Column (name = "Length")
    private float length;
}
