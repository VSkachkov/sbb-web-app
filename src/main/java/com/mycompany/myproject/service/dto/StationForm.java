package com.mycompany.myproject.service.dto;


import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class StationForm {

    String stationName;
    String cantonName;

    public StationForm() {
    }

    public StationForm(String stationName, String cantonName) {
        this.stationName = stationName;
        this.cantonName = cantonName;
    }
}
