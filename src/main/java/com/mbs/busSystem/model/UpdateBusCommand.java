package com.mbs.busSystem.model;


public class UpdateBusCommand {

    private Integer id;
    private Bus bus;

    public UpdateBusCommand(Integer id, Bus bus) {
        this.id = id;
        this.bus = bus;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Bus getBus() {
        return bus;
    }

    public void setBus(Bus bus) {
        this.bus = bus;
    }
}

