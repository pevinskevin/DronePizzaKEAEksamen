package com.pevinskevin.dronepizza.Reposittory;

import com.pevinskevin.dronepizza.Model.Drone;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DroneRepository extends JpaRepository<Drone, Long> {
}
