package com.pevinskevin.dronepizza.Controller;

import com.pevinskevin.dronepizza.Model.Delivery;
import com.pevinskevin.dronepizza.Service.DeliveryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class DeliveryController {
    @Autowired
    private DeliveryService deliveryService;

    @GetMapping("/deliveries")
    public List<Delivery> getListOfUndeliveredOrders(){
    return deliveryService.getAllDeliveriesWhereIsDeliveredEqualsFalse();
    }
}
