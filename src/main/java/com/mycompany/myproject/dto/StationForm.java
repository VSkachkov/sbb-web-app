package com.mycompany.myproject.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StationForm {

    String stationName;
    String cantonName;
    Float latitude;
    Float longitude;

    public StationForm() {
    }

    public StationForm(String stationName, String cantonName) {
        this.stationName = stationName;
        this.cantonName = cantonName;
    }
}
