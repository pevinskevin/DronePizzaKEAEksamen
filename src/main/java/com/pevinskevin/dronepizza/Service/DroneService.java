package com.pevinskevin.dronepizza.Service;
import com.pevinskevin.dronepizza.Model.Drone;
import com.pevinskevin.dronepizza.Model.DroneStatus;
import com.pevinskevin.dronepizza.Model.Station;
import com.pevinskevin.dronepizza.Reposittory.DroneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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

    public List<Drone> getAllDronesByStatus(DroneStatus status) {
        return droneRepository.findAllByOperationalStatus(status);
    }

    public Drone addNewDrone() {
        Station station = stationService.getStationById(stationService.returnStationIdWithLeastDrones());
        Drone drone = new Drone(UUID.randomUUID(), DroneStatus.I_DRIFT, station);
        return droneRepository.save(drone);
    }

    public Drone enableDrone(long droneId){
        List<Drone> list = getAllDrones();
        if (droneId > list.size() || droneId <= 0){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Drone not found - invalid ID.");
        }
        Drone drone = getDroneById(droneId);
        if (drone.getOperationalStatus() != DroneStatus.I_DRIFT){
            drone.setOperationalStatus(DroneStatus.I_DRIFT);
            return saveDrone(drone);
        } else {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Drone is already enabled");
        }
    }

    public Drone disableDrone(long droneId){
        List<Drone> list = getAllDrones();
        if (droneId > list.size() || droneId <= 0){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Drone not found - invalid ID.");
        }
        Drone drone = getDroneById(droneId);
        if (drone.getOperationalStatus() != DroneStatus.UDE_AF_DRIFT){
            drone.setOperationalStatus(DroneStatus.UDE_AF_DRIFT);
            return saveDrone(drone);
        } else {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Drone is already disabled");
        }
    }

    public Drone retireDrone(long droneId){
        List<Drone> list = getAllDrones();
        if (droneId > list.size() || droneId <= 0){
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Drone not found - invalid ID.");
        }
        Drone drone = getDroneById(droneId);
        if (drone.getOperationalStatus() != DroneStatus.UDFASET){
            drone.setOperationalStatus(DroneStatus.UDFASET);
            return saveDrone(drone);
        } else {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Drone is already retired");
        }
    }
}
