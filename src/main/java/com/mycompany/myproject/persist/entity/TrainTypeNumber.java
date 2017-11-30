package com.mycompany.myproject.persist.entity;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@ToString
@Getter
@Setter
@EqualsAndHashCode
@Entity
@Table(name = "Train_types_numbers", schema = "SBB_DB")
public class TrainTypeNumber implements Serializable {

    @Id
    @GenericGenerator(name = "generator", strategy = "increment")
    @GeneratedValue(generator = "generator")
    @Column(name = "train_types_number_id")
    private Long trainTypeNumberId;

    @Basic
    @Column(name = "train_type_name")
    private String trainTypeName;

}
