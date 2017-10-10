package com.mycompany.myproject.persist.entity;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.List;

@Entity // This tells Hibernate to make a table out of this class
@Table (name = "Trains")
public class Train {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    @Column (name = "trainNumber")
    private Long trainNumber;

    @Column (name = "Train_name")
    private String Train_name;

    @Column (name = "Depart_MON")
    private boolean depart_mon;

    @Column (name = "Depart_TUE")
    private boolean depart_tue;

    @Column (name = "Depart_WED")
    private boolean depart_wed;

    @Column (name = "Depart_THU")
    private boolean depart_thu;

    @Column (name = "Depart_FRI")
    private boolean depart_fri;

    @Column (name = "Depart_SAT")
    private boolean depart_sat;

    @Column (name = "Depart_SUN")
    private boolean depart_sun;

    @Column (name = "train_type_id")
    private Long train_type_id;


    public Long getTrainNumber() {
        return trainNumber;
    }

    public void setTrainNumber(Long trainNumber) {
        this.trainNumber = trainNumber;
    }

    public String getTrain_name() {
        return Train_name;
    }

    public void setTrain_name(String train_name) {
        Train_name = train_name;
    }

    public boolean isDepart_mon() {
        return depart_mon;
    }

    public void setDepart_mon(boolean depart_mon) {
        this.depart_mon = depart_mon;
    }

    public boolean isDepart_tue() {
        return depart_tue;
    }

    public void setDepart_tue(boolean depart_tue) {
        this.depart_tue = depart_tue;
    }

    public boolean isDepart_wed() {
        return depart_wed;
    }

    public void setDepart_wed(boolean depart_wed) {
        this.depart_wed = depart_wed;
    }

    public boolean isDepart_thu() {
        return depart_thu;
    }

    public void setDepart_thu(boolean depart_thu) {
        this.depart_thu = depart_thu;
    }

    public boolean isDepart_fri() {
        return depart_fri;
    }

    public void setDepart_fri(boolean depart_fri) {
        this.depart_fri = depart_fri;
    }

    public boolean isDepart_sat() {
        return depart_sat;
    }

    public void setDepart_sat(boolean depart_sat) {
        this.depart_sat = depart_sat;
    }

    public boolean isDepart_sun() {
        return depart_sun;
    }

    public void setDepart_sun(boolean depart_sun) {
        this.depart_sun = depart_sun;
    }

    public Long getTrain_type_id() {
        return train_type_id;
    }

    public void setTrain_type_id(Long train_type_id) {
        this.train_type_id = train_type_id;
    }
}
