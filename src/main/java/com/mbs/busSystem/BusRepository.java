package com.mbs.busSystem;

import com.mbs.busSystem.model.Bus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BusRepository extends JpaRepository <Bus, Integer> {

    List<Bus> findByBusNameContaining(String name);
}
