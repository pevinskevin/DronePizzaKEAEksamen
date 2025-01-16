package com.pevinskevin.dronepizza.Model;

import jakarta.persistence.*;

import java.time.LocalTime;
import java.util.List;

public class Delivery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String address;
    private LocalTime expectedDeliveryTime;
    private LocalTime actualDeliveryTime;
    @ManyToOne
    private Drone drone;
    @OneToMany
    private List<Pizza> pizzas;

    public Delivery(String address, LocalTime expectedDeliveryTime, LocalTime actualDeliveryTime, Drone drone, List<Pizza> pizzas) {
        this.address = address;
        this.expectedDeliveryTime = expectedDeliveryTime;
        this.actualDeliveryTime = actualDeliveryTime;
        this.drone = drone;
        this.pizzas = pizzas;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public LocalTime getExpectedDeliveryTime() {
        return expectedDeliveryTime;
    }

    public void setExpectedDeliveryTime(LocalTime expectedDeliveryTime) {
        this.expectedDeliveryTime = expectedDeliveryTime;
    }

    public LocalTime getActualDeliveryTime() {
        return actualDeliveryTime;
    }

    public void setActualDeliveryTime(LocalTime actualDeliveryTime) {
        this.actualDeliveryTime = actualDeliveryTime;
    }

    public Drone getDrone() {
        return drone;
    }

    public void setDrone(Drone drone) {
        this.drone = drone;
    }

    public List<Pizza> getPizzas() {
        return pizzas;
    }

    public void setPizzas(List<Pizza> pizzas) {
        this.pizzas = pizzas;
    }
}
