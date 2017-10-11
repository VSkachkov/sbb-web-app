package com.mycompany.myproject.persist.entity;

import javax.persistence.*;

@Entity // This tells Hibernate to make a table out of this class
@Table (name = "Stations")
public class Station {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column (name = "station_id")
    private Long station_id;

    @Column(name = "station_name")
    private String station_name;

//    @ManyToOne(fetch =FetchType.LAZY)
//    @JoinTable (name = "Cantons")
//    @JoinColumn (name = "cantonOwner_id", referencedColumnName = "canton_id", nullable = false)
//    private Canton cantonWithStations;

    @Column (name = "is_NODE")
    private boolean is_NODE;

    @Column (name = "canton_id")
    private Long canton_id;

    public Long getId() {
        return station_id;
    }

    public void setId(Long id) {
        this.station_id = id;
    }

    public String getName() {
        return station_name;
    }

    public void setName(String name) {
        this.station_name = name;
    }

    public boolean isNode() {
        return is_NODE;
    }

    public void setNode(boolean node) {
        is_NODE = node;
    }

    public Long getCantonOwner_id() {
        return canton_id;
    }

    public void setCantonOwner_id(Long cantonOwner_id) {
        this.canton_id = cantonOwner_id;
    }
}
