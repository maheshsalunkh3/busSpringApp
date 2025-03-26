package com.mbs.busSystem.model;
import jakarta.persistence.*;

@Entity
@Table (name = "bus")
public class Bus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "id")
    private Integer id;

    @Column (name = "busName")
    private String busName;

}
