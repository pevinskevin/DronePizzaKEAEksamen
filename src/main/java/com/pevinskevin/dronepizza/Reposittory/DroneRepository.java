package com.pevinskevin.dronepizza.Reposittory;

import com.pevinskevin.dronepizza.Model.Drone;
import com.pevinskevin.dronepizza.Model.DroneStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DroneRepository extends JpaRepository<Drone, Long> {
    List<Drone> findAllByOperationalStatus(DroneStatus operationalStatus);
}
