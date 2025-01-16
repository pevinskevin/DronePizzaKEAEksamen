package com.pevinskevin.dronepizza.Config;

import com.pevinskevin.dronepizza.Model.*;
import com.pevinskevin.dronepizza.Service.DeliveryService;
import com.pevinskevin.dronepizza.Service.DroneService;
import com.pevinskevin.dronepizza.Service.PizzaService;
import com.pevinskevin.dronepizza.Service.StationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component
public class TestData implements CommandLineRunner {

    @Autowired
    DeliveryService deliveryService;
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

        droneService.saveDrone(new Drone(UUID.randomUUID(), DroneStatus.I_DRIFT, station1));
        droneService.saveDrone(new Drone(UUID.randomUUID(), DroneStatus.I_DRIFT, station1));
        droneService.saveDrone(new Drone(UUID.randomUUID(), DroneStatus.I_DRIFT, station2));
        droneService.saveDrone(new Drone(UUID.randomUUID(), DroneStatus.I_DRIFT, station3));

        deliveryService.saveDelivery(new Delivery("Kungsgatan 1", LocalTime.of(12, 0), pizzaService.getPizzaById(1L)));
        deliveryService.saveDelivery(new Delivery("Kungsgatan 2", LocalTime.of(12, 0), pizzaService.getPizzaById(2L)));
        deliveryService.saveDelivery(new Delivery("Kungsgatan 3", LocalTime.of(13, 0), pizzaService.getPizzaById(3L)));
        deliveryService.saveDelivery(new Delivery("Kungsgatan 4", LocalTime.of(12, 0), pizzaService.getPizzaById(4L)));
    }
}
