package com.pevinskevin.dronepizza.Model;

import jakarta.persistence.*;

import java.util.UUID;

@Entity
public class Drone {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @ManyToOne
    private Station station;
    private UUID serialUUID;
    private DroneStatus operationalStatus;

    public Drone() {
    }

    public Drone(UUID serialUUID, DroneStatus operationalStatus) {
        this.serialUUID = serialUUID;
        this.operationalStatus = operationalStatus;
    }

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
