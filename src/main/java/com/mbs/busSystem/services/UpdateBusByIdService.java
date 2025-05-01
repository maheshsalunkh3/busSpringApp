package com.mbs.busSystem.services;

import com.mbs.busSystem.BusRepository;
import com.mbs.busSystem.Command;
import com.mbs.busSystem.model.Bus;
import com.mbs.busSystem.model.BusDTO;
import com.mbs.busSystem.model.UpdateBusCommand;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UpdateBusByIdService implements Command<UpdateBusCommand, BusDTO> {


    private final BusRepository busRepository;

    public UpdateBusByIdService(BusRepository busRepository) {
        this.busRepository = busRepository;
    }

    @Override
    public ResponseEntity<BusDTO> execute(UpdateBusCommand busCommand) {

        Optional<Bus> busUpdated = busRepository.findById(busCommand.getId());

        if (busUpdated.isPresent()){
            Bus bus = busCommand.getBus();
            bus.setId(busCommand.getId());
            busRepository.save(bus);

            return ResponseEntity.ok(new BusDTO(bus));
        }
        return null;
    }
}
