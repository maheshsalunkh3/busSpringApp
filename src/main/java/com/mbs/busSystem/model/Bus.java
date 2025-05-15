package com.mbs.busSystem.model;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table (name = "bus")
public class Bus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    private Integer id;

    @Column (name = "busName")
    private String busName;

    public Bus() {
    }

    public Bus(Integer id){

    }

    public Bus(Integer id, String busName) {
        this.id = id;
        this.busName = busName;
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
