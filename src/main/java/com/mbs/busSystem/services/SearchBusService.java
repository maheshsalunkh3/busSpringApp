package com.mbs.busSystem.services;

import com.mbs.busSystem.BusRepository;
import com.mbs.busSystem.Query;
import com.mbs.busSystem.model.Bus;
import com.mbs.busSystem.model.BusDTO;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SearchBusService implements Query <String, List<BusDTO>> {

    private final BusRepository busRepository;

    public SearchBusService(BusRepository busRepository) {
        this.busRepository = busRepository;
    }

    @Override
    public ResponseEntity<List<BusDTO>> execute(String name) {
        return ResponseEntity.ok(busRepository.findByBusNameContaining(name)
                .stream().map(BusDTO::new)
                .toList());
    }
}
