package com.pevinskevin.dronepizza.Config;

import com.pevinskevin.dronepizza.Model.*;
import com.pevinskevin.dronepizza.Service.DeliveryService;
import com.pevinskevin.dronepizza.Service.DroneService;
import com.pevinskevin.dronepizza.Service.PizzaService;
import com.pevinskevin.dronepizza.Service.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.UUID;

@Component
public class TestData implements CommandLineRunner {


    @Autowired
    DroneService droneService;
    @Autowired
    PizzaService pizzaService;
    @Autowired
    StationService stationService;

    @Override
    public void run(String... args) throws Exception {

        pizzaService.savePizza(new Pizza("Margherita", 50));
        pizzaService.savePizza(new Pizza("Pepperoni", 60));
        pizzaService.savePizza(new Pizza("Hawaiian", 55));
        pizzaService.savePizza(new Pizza("Veggie", 45));
        pizzaService.savePizza(new Pizza("BBQ Chicken", 65));

        Station station1 = stationService.saveStation(new Station(55.41, 12.34));
        Station station2 = stationService.saveStation(new Station(55.42, 12.35));
        Station station3 = stationService.saveStation(new Station(55.43, 12.36));

        droneService.saveDrone(new Drone(UUID.randomUUID(), DroneStatus.UDE_AF_DRIFT, station1));
        droneService.saveDrone(new Drone(UUID.randomUUID(), DroneStatus.UDE_AF_DRIFT, station2));
        droneService.saveDrone(new Drone(UUID.randomUUID(), DroneStatus.UDE_AF_DRIFT, station3));
    }
}
