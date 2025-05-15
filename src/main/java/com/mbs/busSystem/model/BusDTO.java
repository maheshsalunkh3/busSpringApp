package com.mbs.busSystem.model;

import java.util.Objects;

public class BusDTO {

    private Integer id;
    private String busName;

    public BusDTO(Bus bus) {
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof BusDTO)) return false;
        BusDTO busDTO = (BusDTO) o;
        return Objects.equals(id, busDTO.id) &&
                Objects.equals(busName, busDTO.busName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, busName);
    }
}