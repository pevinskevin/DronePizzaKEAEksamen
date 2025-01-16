package com.pevinskevin.dronepizza.Reposittory;

import com.pevinskevin.dronepizza.Model.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DeliveryRepository extends JpaRepository<Delivery, Long> {
    List<Delivery> findAllByIsDeliveredIsFalse();

    List<Delivery> findAllByIsDeliveredIsFalseAndDroneIsNull();

}
