package com.mbs.busSystem.validator;

import com.mbs.busSystem.exceptions.ErrorMessages;
import com.mbs.busSystem.exceptions.NotValidException;
import com.mbs.busSystem.model.Bus;
import org.springframework.util.StringUtils;

public class Validator {

    public Validator() {
    }

    public static void execute(Bus bus){
        if(StringUtils.isEmpty(bus.getBusName())) {
            throw new NotValidException(ErrorMessages.NAME_REQUIRED.getMessage());
        }
    }
}
