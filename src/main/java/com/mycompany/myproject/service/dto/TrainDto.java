package com.mycompany.myproject.service.dto;

import org.dozer.Mapping;

public class TrainDto {

    @Mapping ( "trainNumber")
    private Long trainNumber;

    @Mapping ("Train_name")
    private String Train_name;

    @Mapping ("Depart_MON")
    private boolean depart_mon;

    @Mapping ("Depart_TUE")
    private boolean depart_tue;

    @Mapping ("Depart_WED")
    private boolean depart_wed;

    @Mapping ( "Depart_THU")
    private boolean depart_thu;

    @Mapping ("Depart_FRI")
    private boolean depart_fri;

    @Mapping ("Depart_SAT")
    private boolean depart_sat;

    @Mapping ("Depart_SUN")
    private boolean depart_sun;

    @Mapping ("train_type_id")
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
