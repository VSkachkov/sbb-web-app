//package com.mycompany.myproject.persist.entity;
//
//import lombok.EqualsAndHashCode;
//import lombok.Getter;
//import lombok.Setter;
//import lombok.ToString;
//
//import javax.persistence.*;
//import java.io.Serializable;
//
//@ToString
//@Getter
//@Setter
//@EqualsAndHashCode
//@Entity
//@Table(name = "RAILROAD_HAULS", schema = "SBB_DB")
//public class Section  implements Serializable {
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name = "haul_id")
//    private Long sectionId;
//
//    //    @ManyToOne(cascade = CascadeType.MERGE)
//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "station_One_ID")
//    private Station stationOne;
//
//    //    @ManyToOne(cascade = CascadeType.MERGE)
//    @ManyToOne(fetch = FetchType.EAGER)
//    @JoinColumn(name = "station_Two_ID")
//    private Station stationTwo;
//
//    @Basic
//    @Column(name = "price_Index")
//    private float priceIndex;
//
//
//}
