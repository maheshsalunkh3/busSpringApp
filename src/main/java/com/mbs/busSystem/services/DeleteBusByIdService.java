package com.mbs.busSystem.services;

import com.mbs.busSystem.BusRepository;
import com.mbs.busSystem.Command;
import com.mbs.busSystem.exceptions.NotFoundException;
import com.mbs.busSystem.model.Bus;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class DeleteBusByIdService implements Command <Integer, Void> {

    private final BusRepository busRepository;

    public DeleteBusByIdService (BusRepository busRepository){
        this.busRepository = busRepository;
    }
    @Override
    public ResponseEntity<Void> execute(Integer id) {

        Optional<Bus> busDeleted = busRepository.findById(id);

        if (busDeleted.isPresent()){
            busRepository.deleteById(id);
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        }
        throw new NotFoundException();
    }
}
