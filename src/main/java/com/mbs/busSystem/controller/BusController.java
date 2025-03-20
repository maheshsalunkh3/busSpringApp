package com.mbs.busSystem.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BusController {

    @PostMapping
    public ResponseEntity <String> createBus(){
        return ResponseEntity.status(HttpStatus.CREATED).body("Bus Created");
    }
    @GetMapping
    public ResponseEntity <String> getAllBus(){
        return ResponseEntity.status(HttpStatus.OK).body("All Bus Fetched");
    }

//    @GetMapping
//    public String getBusById(){
//        return "Bus with Id Fetched";
//    }

    @PutMapping
    public ResponseEntity <String> updateBusById(){
        return ResponseEntity.status(HttpStatus.OK).body("Bus Updated");
    }

    @DeleteMapping
    public ResponseEntity <String> deleteBusById(){
        return ResponseEntity.status(HttpStatus.NO_CONTENT).body("Bus Deleted");
    }
}
