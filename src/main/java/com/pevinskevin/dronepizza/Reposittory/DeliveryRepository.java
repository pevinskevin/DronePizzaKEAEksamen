package com.pevinskevin.dronepizza.Reposittory;

import com.pevinskevin.dronepizza.Model.Delivery;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DeliveryRepository extends JpaRepository<Delivery, Long> {
}
