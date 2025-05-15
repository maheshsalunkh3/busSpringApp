package com.mbs.busSystem;

import com.mbs.busSystem.exceptions.NotFoundException;
import com.mbs.busSystem.model.Bus;
import com.mbs.busSystem.model.BusDTO;
import com.mbs.busSystem.services.GetAllBusService;
import com.mbs.busSystem.services.GetBusByIdService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.ResponseEntity;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.Mockito.*;

public class GetBusServiceTest {

    @Mock
    private BusRepository busRepository;

    @InjectMocks
    private GetBusByIdService getBusByIdService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void given_bus_exists_when_get_bus_service_return_bus_dto(){
        //Given
        Bus bus = new Bus();
        bus.setId(1);
        bus.setBusName("LAALPARI");

        when(busRepository.findById(1)).thenReturn(Optional.of(bus));

        //When
        ResponseEntity<BusDTO> response = getBusByIdService.execute(1);

        //Then
        assertEquals(ResponseEntity.ok(new BusDTO(bus)), response);
        verify(busRepository, times(1)).findById(1);

    }

    @Test
    public void given_bus_does_not_exist_when_get_bus_service_throw_bus_not_found_exception(){
        //Given
        when(busRepository.findById(1)).thenReturn(Optional.empty());

        //When & Then
        assertThrows(NotFoundException.class, () -> getBusByIdService.execute(1));
        verify(busRepository, times(1)).findById(1);
    }
}
