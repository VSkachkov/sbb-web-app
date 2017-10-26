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
public class Carriage {
    @Id
    @GenericGenerator(name = "generator", strategy = "increment")
    @GeneratedValue(generator = "generator")
    @Column(name = "carriage_id")
    private Long carId;



    @Basic
    @Column(name = "carriage_name")
    private String cantonName;

    @Basic
    @Column (name = "seats")
    private String seatsNumber;

    @Basic
    @Column (name="Carriage_price_rate")
    private float carPriceRate;

}
