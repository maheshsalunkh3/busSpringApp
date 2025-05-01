package com.mbs.busSystem.services;

import com.mbs.busSystem.BusRepository;
import com.mbs.busSystem.Command;
import com.mbs.busSystem.model.Bus;
import com.mbs.busSystem.model.BusDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CreateBusService implements Command <Bus, BusDTO> {

    private final BusRepository busRepository;

    public CreateBusService(BusRepository busRepository) {
        this.busRepository = busRepository;
    }

    @Override
    public ResponseEntity<BusDTO> execute(Bus bus) {
        Bus savedBus = busRepository.save(bus);
        return ResponseEntity.status(HttpStatus.CREATED).body(new BusDTO(savedBus));
    }

}
