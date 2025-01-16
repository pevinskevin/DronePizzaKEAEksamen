package com.pevinskevin.dronepizza.Model;

import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;

import java.util.UUID;


public class Drone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private UUID serialUUID;
    private DroneStatus operationalStatus;
    @ManyToOne
    private Station station;

    public Drone(UUID serialUUID, DroneStatus operationalStatus, Station station) {
        this.serialUUID = serialUUID;
        this.operationalStatus = operationalStatus;
        this.station = station;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public UUID getSerialUUID() {
        return serialUUID;
    }

    public void setSerialUUID(UUID serialUUID) {
        this.serialUUID = serialUUID;
    }

    public DroneStatus getOperationalStatus() {
        return operationalStatus;
    }

    public void setOperationalStatus(DroneStatus operationalStatus) {
        this.operationalStatus = operationalStatus;
    }

    public Station getStation() {
        return station;
    }

    public void setStation(Station station) {
        this.station = station;
    }
}
