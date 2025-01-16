package com.pevinskevin.dronepizza.Reposittory;

import com.pevinskevin.dronepizza.Model.Pizza;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PizzaRepository extends JpaRepository<Pizza, Long> {
}
