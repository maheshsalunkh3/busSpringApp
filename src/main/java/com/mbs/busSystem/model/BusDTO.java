package com.mbs.busSystem.model;
import lombok.Data;

public class BusDTO {

    private Integer id;
    private String busName;

    public BusDTO (Bus bus) {
        this.id = bus.getId();
        this.busName = bus.getBusName();
    }

    public BusDTO() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getBusName() {
        return busName;
    }

    public void setBusName(String busName) {
        this.busName = busName;
    }
}
