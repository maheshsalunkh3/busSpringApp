package com.mbs.busSystem;

import com.mbs.busSystem.model.Bus;
import com.mbs.busSystem.model.UpdateBusCommand;
import com.mbs.busSystem.services.UpdateBusByIdService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class UpdateBusServiceTest {

    @Mock
    private BusRepository busRepository;

    @InjectMocks
    private UpdateBusByIdService updateBusByIdService;

    @BeforeEach
    public void setup(){
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void given_bus_exists_when_update_command_then_update_bus(){
        //Given
        Bus bus = new Bus();
        bus.setId(1);
        bus.setBusName("LALPARI");

        Bus updateBus = new Bus();
        bus.setBusName("LAALPARI");

        when(busRepository.findById(1)).thenReturn(Optional.of(bus));
        when(busRepository.findById(1)).thenReturn(Optional.of(bus));
        //When
//        Optional <Bus> savedBus = busRepository.findById(1);
        if(Optional.of(bus).isPresent()){
            updateBusByIdService.execute(new UpdateBusCommand(1, new Bus(1,"LAALPARI")));
        }

        //Then
//        assertEquals();
        verify(busRepository,times(1)).findById(1);
    }
}
