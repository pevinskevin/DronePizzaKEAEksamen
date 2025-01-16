package com.pevinskevin.dronepizza.Model;

import jakarta.persistence.*;

import java.time.LocalTime;

@Entity

public class Delivery {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String address;
    private LocalTime expectedDeliveryTime;
    private LocalTime actualDeliveryTime;
    private Boolean isDelivered = false;
    @ManyToOne
    private Drone drone;
    @ManyToOne
    private Pizza pizza;

    public Delivery() {
    }

    public Delivery(String address, LocalTime expectedDeliveryTime, Pizza pizza) {
        this.address = address;
        this.expectedDeliveryTime = expectedDeliveryTime;
        this.pizza = pizza;
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

    public Boolean getDelivered() {
        return isDelivered;
    }

    public void setDelivered(Boolean delivered) {
        isDelivered = delivered;
    }

    public Pizza getPizza() {
        return pizza;
    }

    public void setPizza(Pizza pizza) {
        this.pizza = pizza;
    }
}
