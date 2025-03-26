package com.mbs.busSystem.controller;

import com.mbs.busSystem.services.CreateBusService;
import com.mbs.busSystem.services.DeleteBusByIdService;
import com.mbs.busSystem.services.GetAllBusService;
import com.mbs.busSystem.services.UpdateBusByIdService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class BusController {

    private final CreateBusService createBusService;
    private final GetAllBusService getAllBusService;
    private final UpdateBusByIdService updateBusByIdService;
    private final DeleteBusByIdService deleteBusByIdService;

    public BusController(CreateBusService createBusService,
                         GetAllBusService getAllBusService,
                         UpdateBusByIdService updateBusByIdService,
                         DeleteBusByIdService deleteBusByIdService) {
        this.createBusService = createBusService;
        this.getAllBusService = getAllBusService;
        this.updateBusByIdService = updateBusByIdService;
        this.deleteBusByIdService = deleteBusByIdService;
    }


    @PostMapping
    public ResponseEntity <String> createBus(){
        return createBusService.execute(null);
    }
    @GetMapping
    public ResponseEntity <String> getAllBus(){
        return getAllBusService.execute(null);
    }

//    @GetMapping
//    public String getBusById(){
//        return "Bus with Id Fetched";
//    }

    @PutMapping
    public ResponseEntity <String> updateBusById(){
        return updateBusByIdService.execute(null);
    }

    @DeleteMapping
    public ResponseEntity <String> deleteBusById(){
        return deleteBusByIdService.execute(null);
    }
}
