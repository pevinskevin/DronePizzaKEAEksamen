package com.pevinskevin.dronepizza.Service;
import com.pevinskevin.dronepizza.Model.Delivery;
import com.pevinskevin.dronepizza.Model.Drone;
import com.pevinskevin.dronepizza.Model.DroneStatus;
import com.pevinskevin.dronepizza.Reposittory.DeliveryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalTime;
import java.util.List;
import java.util.Random;

@Service
public class DeliveryService {
    @Autowired
    private DeliveryRepository deliveryRepository;
    @Autowired
    private PizzaService pizzaService;
    @Autowired
    private DroneService droneService;

    public Delivery saveDelivery(Delivery delivery) {
        return deliveryRepository.save(delivery);
    }

    public Delivery createNewDelivery(String address, long pizzaId) {
        Delivery delivery = new Delivery(address, LocalTime.now().plusMinutes(30), pizzaService.getPizzaById(pizzaId));
        return deliveryRepository.save(delivery);
    }

    public Delivery getDeliveryById(Long id) {
        return deliveryRepository.findById(id).orElse(null);
    }

    public List<Delivery> getAllDeliveriesWhereIsDeliveredIsFalse() {
        List<Delivery> deliveries = deliveryRepository.findAllByIsDeliveredIsFalse();
        return deliveries;
    }

    public List<Delivery> findAllByIsDeliveredIsFalseAndDroneIdIsNull() {
        List<Delivery> deliveries = deliveryRepository.findAllByIsDeliveredIsFalseAndDroneIsNull();
        return deliveries;
    }

    public Delivery assignDroneToDeliveryUsingDeliveryId(long deliveryId) {
        Delivery delivery = getDeliveryById(deliveryId);
        List<Drone> drones = droneService.getAllDronesByStatus(DroneStatus.I_DRIFT);
        Random random = new Random(drones.size() + 1);
        Long randomDroneId = 1 + random.nextLong(drones.size());
        delivery.setDrone(droneService.getDroneById(randomDroneId));
        return deliveryRepository.save(delivery);
    }

    public Delivery updateIsDeliveredToTrue(long deliveryId) {
        Delivery delivery = getDeliveryById(deliveryId);
        delivery.setDelivered(true);
        delivery.setActualDeliveryTime(LocalTime.now());
        return deliveryRepository.save(delivery);
    }
}
