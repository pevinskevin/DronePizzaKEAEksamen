package com.pevinskevin.dronepizza.Service;
import com.pevinskevin.dronepizza.Model.Drone;
import com.pevinskevin.dronepizza.Model.DroneStatus;
import com.pevinskevin.dronepizza.Model.Station;
import com.pevinskevin.dronepizza.Reposittory.DroneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class DroneService {
    @Autowired
    private DroneRepository droneRepository;
    @Autowired
    private StationService stationService;

    public Drone saveDrone(Drone drone) {
        return droneRepository.save(drone);
    }

    public Drone getDroneById(Long id) {
        return droneRepository.findById(id).orElse(null);
    }

    public List<Drone> getAllDrones() {
        return droneRepository.findAll();
    }


    public Drone addNewDrone() {
//    A list of stations is created - check.
//    The number of drones pr. station is counted.
//    The station with the least drones is returned.
//    A new drone is created and assigned to the returned station ID.

        Station station = stationService.getStationById(stationService.returnStationIdWithLeastDrones());
        Drone drone = new Drone(UUID.randomUUID(), DroneStatus.I_DRIFT, station);
        return droneRepository.save(drone);
    }
}
