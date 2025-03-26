package com.mbs.busSystem.services;

import com.mbs.busSystem.Command;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class UpdateBusByIdService implements Command<Void, String> {


    @Override
    public ResponseEntity<String> execute(Void input) {
        return ResponseEntity.status(HttpStatus.OK).body("Bus Updated");
    }
}
