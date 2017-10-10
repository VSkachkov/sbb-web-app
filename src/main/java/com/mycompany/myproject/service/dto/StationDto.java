package com.mycompany.myproject.service.dto;

import com.mycompany.myproject.persist.entity.Canton;
import org.dozer.Mapping;

public class StationDto {

    @Mapping("station_id")
    private Long station_id;

    @Mapping("station_name")
    private String station_name;

    @Mapping ("is_NODE")
    private boolean is_Node;

    @Mapping ("canton_id")
    private Long canton_id;

    public Long getStation_id() {
        return station_id;
    }

    public void setStation_id(Long station_id) {
        this.station_id = station_id;
    }

    public String getStation_name() {
        return station_name;
    }

    public void setStation_name(String station_name) {
        this.station_name = station_name;
    }

    public boolean isIs_Node() {
        return is_Node;
    }

    public void setIs_Node(boolean is_Node) {
        this.is_Node = is_Node;
    }

    public Long getCanton_id() {
        return canton_id;
    }

    public void setCanton_id(Long canton_id) {
        this.canton_id = canton_id;
    }
}
