package com.mbs.busSystem.controller;

import org.springframework.web.bind.annotation.*;

@RestController
public class BusController {

    @PostMapping
    public String createBus(){
        return "Bus Created";
    }
    @GetMapping
    public String getAllBus(){
        return "All Bus Fetched";
    }

//    @GetMapping
//    public String getBusById(){
//        return "Bus with Id Fetched";
//    }

    @PutMapping
    public String updateBusById(){
        return "Bus Updated";
    }

    @DeleteMapping
    public String deleteBusById(){
        return "Bus Deleted";
    }
}
