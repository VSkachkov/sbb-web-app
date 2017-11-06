package com.mycompany.myproject.dto;

import com.mycompany.myproject.persist.entity.Section;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SectionDto {
    private Long sectionId;
    private Long stationFromId;
    private Long stationToId;
    private float length;

    public SectionDto() {
    }

    public SectionDto(Section section) {
        this.sectionId = section.getSectionId();
        this.stationFromId = section.getStationFromId().getStationId();
        this.stationToId = section.getStationToId().getStationId();
        this.length = section.getLength();
    }
}
