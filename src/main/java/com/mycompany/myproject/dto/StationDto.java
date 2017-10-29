package com.mycompany.myproject.dto;

import com.mycompany.myproject.persist.entity.Station;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class  StationDto {


    private Long stationId;
    private Long cantonId;
    private String stationName;
    private boolean node;

    public StationDto(){

    }

    public StationDto(Station station){
        this.stationId = station.getStationId();
        this.stationName = station.getStationName();
        this.cantonId = station.getCanton().getCantonId();
//        this.node = station.isNode();
    }

}
