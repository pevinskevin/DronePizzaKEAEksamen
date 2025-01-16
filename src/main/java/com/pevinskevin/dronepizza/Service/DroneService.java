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
        Station station = stationService.getStationById(stationService.returnStationIdWithLeastDrones());
        Drone drone = new Drone(UUID.randomUUID(), DroneStatus.I_DRIFT, station);
        return droneRepository.save(drone);
    }

    public Drone enableDrone(long droneId){
        Drone drone = getDroneById(droneId);
        drone.setOperationalStatus(DroneStatus.I_DRIFT);
        return saveDrone(drone);
    }

    public Drone disableDrone(long droneId){
        Drone drone = getDroneById(droneId);
        drone.setOperationalStatus(DroneStatus.UDE_AF_DRIFT);
        return saveDrone(drone);
    }

    public Drone retireDrone(long droneId){
        Drone drone = getDroneById(droneId);
        drone.setOperationalStatus(DroneStatus.UDFASET);
        return saveDrone(drone);
    }
}
