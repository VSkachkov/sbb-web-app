package com.mycompany.myproject.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SectionDto {
    private Long sectionId;
    private Long stationFromId;
    private Long stationToId;
    private float length;
}
