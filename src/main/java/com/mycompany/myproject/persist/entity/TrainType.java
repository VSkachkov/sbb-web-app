package com.mycompany.myproject.persist.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;
import javax.persistence.*;

//import com.mycompany.myproject.persist.entity.Car;

import java.io.Serializable;

@ToString
@Getter
@Setter
@EqualsAndHashCode
@Entity
//@Table(name = "Train_types", schema = "SBB_DB", uniqueConstraints =
//@UniqueConstraint(columnNames={"train_type_id", "car_id"}))
//@Embeddable
@Table(name = "Train_types", schema = "SBB_DB")
public class TrainType  implements Serializable {
    @Id
//    @GenericGenerator(name = "generator", strategy = "increment")
//    @GeneratedValue(generator = "generator")
//    @Column(name = "train_type_id")
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "train_type_id")
    private TrainTypeNumber trainTypeNumber;


//    @Id
//    @Basic
//    @Column(name = "car_id")
//    Long car_id;

    @Id
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "Car_id")
    private Car car;

    @Basic
    @Column(name = "train_type_name")
    private String trainTypeName;

    @Basic
    @Column (name="car_number")
    private Long numberOfCars;
}


