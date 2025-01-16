package com.pevinskevin.dronepizza.Service;
import com.pevinskevin.dronepizza.Model.Drone;
import com.pevinskevin.dronepizza.Reposittory.DroneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DroneService {
    @Autowired
    private DroneRepository droneRepository;

    public Drone saveDrone(Drone drone) {
        return droneRepository.save(drone);
    }

    public Drone getDroneById(Long id) {
        return droneRepository.findById(id).orElse(null);
    }

    public List<Drone> getAllDrones() {
        return droneRepository.findAll();
    }
}
