package com.mbs.busSystem.services;

import com.mbs.busSystem.BusRepository;
import com.mbs.busSystem.Command;
import com.mbs.busSystem.exceptions.NotFoundException;
import com.mbs.busSystem.model.Bus;
import com.mbs.busSystem.model.BusDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Objects;
import java.util.Optional;

@Service
public class GetBusByIdService implements Command <Integer, BusDTO> {

    private final BusRepository busRepository;

    public GetBusByIdService(BusRepository busRepository) {
        this.busRepository = busRepository;
    }


    @Override
    public ResponseEntity<BusDTO> execute(Integer input) {
        Optional <Bus> bus = busRepository.findById(input);

        if (bus.isPresent()) {
            return ResponseEntity.ok(new BusDTO(bus.get()));
        }
        throw new NotFoundException();
    }
}
