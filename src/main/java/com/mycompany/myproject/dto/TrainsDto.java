package com.mycompany.myproject.dto;

import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
public class TrainsDto implements Serializable {
    private List<TrainDto> trains;

    @Override
    public String toString() {
        return "TrainsDto{" +
                "trains=" + trains +
                '}';
    }
}
