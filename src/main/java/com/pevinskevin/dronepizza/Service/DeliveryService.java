package com.pevinskevin.dronepizza.Service;
import com.pevinskevin.dronepizza.Model.Delivery;
import com.pevinskevin.dronepizza.Reposittory.DeliveryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class DeliveryService {
    @Autowired
    private DeliveryRepository deliveryRepository;

    public Delivery saveDelivery(Delivery delivery) {
        return deliveryRepository.save(delivery);
    }

    public Delivery getDeliveryById(Long id) {
        return deliveryRepository.findById(id).orElse(null);
    }
}
