package com.pevinskevin.dronepizza.Service;
import com.pevinskevin.dronepizza.Model.Delivery;
import com.pevinskevin.dronepizza.Model.Drone;
import com.pevinskevin.dronepizza.Model.DroneStatus;
import com.pevinskevin.dronepizza.Reposittory.DeliveryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

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

    //Will create a new delivery with the given address and pizzaId - will return error if address is empty or insufficient in length, or if pizzaId is not found
    public Delivery createNewDelivery(String address, long pizzaId) {
        if (address == null || address.isEmpty() || address.length() < 10) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Address cannot be empty or insufficient in length.");
        } if (pizzaService.getPizzaById(pizzaId) == null || pizzaService.getPizzaById(pizzaId).getId() != pizzaId) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Pizza not found.");
        } else {
            Delivery delivery = new Delivery(address, LocalTime.now().plusMinutes(30), pizzaService.getPizzaById(pizzaId));
            return deliveryRepository.save(delivery);
        }
    }

    public Delivery getDeliveryById(Long id) {
        return deliveryRepository.findById(id).orElse(null);
    }

    //Returns a list of all deliveries where isDelivered is false - will return error if no undelivered orders are found
    public List<Delivery> getAllDeliveriesWhereIsDeliveredIsFalse() {
        List<Delivery> deliveries = deliveryRepository.findAllByIsDeliveredIsFalse();
        if (deliveries.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No undelivered orders found.");
        }
        return deliveries;
    }

    //Returns a list of all deliveries where isDelivered is false and droneId is null - will return error if no undelivered orders are found
    public List<Delivery> findAllByIsDeliveredIsFalseAndDroneIdIsNull() {
        List<Delivery> deliveries = deliveryRepository.findAllByIsDeliveredIsFalseAndDroneIsNull();
        if (deliveries.isEmpty()) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No undelivered orders found.");
        }
        return deliveries;
    }

    //Will assign a drone to a delivery using the deliveryId - will return error if deliveryId is invalid, or if a drone is already assigned to the delivery
    public Delivery assignDroneToDeliveryUsingDeliveryId(long deliveryId) {
        List<Delivery> list = getAllDeliveriesWhereIsDeliveredIsFalse();
        if (deliveryId > list.size() || deliveryId <= 0) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Delivery not found - invalid ID.");
        } if (getDeliveryById(deliveryId).getDrone() != null) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Drone already assigned to delivery.");
        } else {
            Delivery delivery = getDeliveryById(deliveryId);
            List<Drone> drones = droneService.getAllDronesByStatus(DroneStatus.I_DRIFT);
            Random random = new Random(drones.size() + 1);
            Long randomDroneId = 1 + random.nextLong(drones.size());
            delivery.setDrone(droneService.getDroneById(randomDroneId));
            return deliveryRepository.save(delivery);
        }
    }

    //Will update the delivery as delivered using the deliveryId - will return error if deliveryId is invalid, or if the delivery is already marked as delivered
    public Delivery updateIsDeliveredToTrue(long deliveryId) {
        if (getDeliveryById(deliveryId) == null || getDeliveryById(deliveryId).getId() != deliveryId) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Delivery not found.");
        } if(getDeliveryById(deliveryId).getDelivered() == true) {
            throw new ResponseStatusException(HttpStatus.CONFLICT, "Delivery already marked as delivered.");
        } else {
            Delivery delivery = getDeliveryById(deliveryId);
            delivery.setDelivered(true);
            delivery.setActualDeliveryTime(LocalTime.now());
            return deliveryRepository.save(delivery);
        }
    }
}
