package com.mycompany.myproject.dto;

import com.mycompany.myproject.persist.entity.Section;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
public class SectionDto {
    private Long sectionId;
    private Long stationFromId;
    private String stationFromName;
    private Long stationToId;
    private String stationToName;
    private float length;

    public SectionDto() {
    }

    public SectionDto(Section section) {
        this.sectionId = section.getSectionId();
        this.stationFromId = section.getStationFromId().getStationId();
        this.stationFromName = section.getStationFromId().getStationName();
        this.stationToId = section.getStationToId().getStationId();
        this.stationToName = section.getStationToId().getStationName();
        this.length = section.getLength();
    }
}
