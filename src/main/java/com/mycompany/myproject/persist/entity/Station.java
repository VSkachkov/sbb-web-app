package com.mycompany.myproject.persist.entity;

import javax.persistence.*;

@Entity // This tells Hibernate to make a table out of this class
@Table
public class Station {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column
    private Long id;

    @Column
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn (name = "CANTON_ID", nullable = false)
    private Canton canton;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public Long getCanton() {
        return canton.getId();
    }

    public void setCanton(Canton canton) {

        this.canton = canton;
    }
}
