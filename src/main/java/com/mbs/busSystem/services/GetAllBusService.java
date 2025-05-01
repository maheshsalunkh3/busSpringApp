package com.mbs.busSystem.services;

import com.mbs.busSystem.BusRepository;
import com.mbs.busSystem.Query;
import com.mbs.busSystem.model.Bus;
import com.mbs.busSystem.model.BusDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GetAllBusService implements Query<Void, List<BusDTO>> {


    private final BusRepository busRepository;

    public GetAllBusService(BusRepository busRepository) {
        this.busRepository = busRepository;
    }

    @Override
    public ResponseEntity<List<BusDTO>> execute(Void input) {
        List <Bus> busList = busRepository.findAll();
        List <BusDTO> busDTOS = busList.stream().map(BusDTO::new).toList();
        return ResponseEntity.status(HttpStatus.OK).body(busDTOS);
    }

}
