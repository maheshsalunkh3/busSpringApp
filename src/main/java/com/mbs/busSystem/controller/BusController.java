package com.mbs.busSystem.controller;

import com.mbs.busSystem.exceptions.NotFoundException;
import com.mbs.busSystem.model.Bus;
import com.mbs.busSystem.model.BusDTO;
import com.mbs.busSystem.model.ErrorResponse;
import com.mbs.busSystem.model.UpdateBusCommand;
import com.mbs.busSystem.services.*;
import jakarta.persistence.Entity;
import jakarta.persistence.criteria.CriteriaBuilder;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BusController {

    private final CreateBusService createBusService;
    private final GetAllBusService getAllBusService;
    private final UpdateBusByIdService updateBusByIdService;
    private final DeleteBusByIdService deleteBusByIdService;

    private GetBusByIdService getBusByIdService;

    public BusController(CreateBusService createBusService,
                         GetAllBusService getAllBusService,
                         GetBusByIdService getBusByIdService,
                         UpdateBusByIdService updateBusByIdService,
                         DeleteBusByIdService deleteBusByIdService) {
        this.createBusService = createBusService;
        this.getAllBusService = getAllBusService;
        this.getBusByIdService = getBusByIdService;
        this.updateBusByIdService = updateBusByIdService;
        this.deleteBusByIdService = deleteBusByIdService;
    }


    @PostMapping("/bus")
    public ResponseEntity <BusDTO> createBus(@RequestBody Bus bus){
        return createBusService.execute(bus);
    }
    @GetMapping("/buses")
    public ResponseEntity <List<BusDTO>> getAllBus(){
        return getAllBusService.execute(null);
    }

    @GetMapping("/bus/{id}")
    public ResponseEntity <BusDTO> getBusById(@PathVariable Integer id){
        return getBusByIdService.execute(id);
    }

    @PutMapping("/bus/{id}")
    public ResponseEntity <BusDTO> updateBusById(@PathVariable Integer id, @RequestBody Bus bus){
        return updateBusByIdService.execute(new UpdateBusCommand(id, bus));
    }

    @DeleteMapping("/bus/{id}")
    public ResponseEntity<Void> deleteBusById(@PathVariable Integer id){
        return deleteBusByIdService.execute(id);
    }

}
