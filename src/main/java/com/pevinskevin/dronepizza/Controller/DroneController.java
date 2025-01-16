package com.pevinskevin.dronepizza.Controller;

import com.pevinskevin.dronepizza.Model.Drone;
import com.pevinskevin.dronepizza.Model.DroneStatus;
import com.pevinskevin.dronepizza.Service.DroneService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DroneController {
    @Autowired
    DroneService droneService;

    @GetMapping("/drones")
    public List<Drone> getAllDrones() {
        return droneService.getAllDrones();
    }

    @PostMapping("/drones/add")
    public Drone addDrone() {
        return droneService.addNewDrone();
    }

    @PostMapping("drones/enable")
    public Drone enableDroneUsingId(long droneId) {
        return droneService.enableDrone(droneId);
    }

    @PostMapping("drones/disable")
    public Drone disableDrongUsingId(long droneId) {
        return droneService.disableDrone(droneId);
    }

    @PostMapping("drones/retire")
    public Drone retireDroneUsingId(long droneId) {
        return droneService.retireDrone(droneId);
    }
}
