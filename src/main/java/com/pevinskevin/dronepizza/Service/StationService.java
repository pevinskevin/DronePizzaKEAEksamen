package com.pevinskevin.dronepizza.Service;
import com.pevinskevin.dronepizza.Model.Station;
import com.pevinskevin.dronepizza.Reposittory.DroneRepository;
import com.pevinskevin.dronepizza.Reposittory.StationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public class StationService {
    @Autowired
    private StationRepository stationRepository;

    public Station saveStation(Station station) {
        return stationRepository.save(station);
    }

    public Station getStationById(Long id) {
        return stationRepository.findById(id).orElse(null);
    }

    public Long returnStationIdWithLeastDrones() {
        int droneCount = 999;
        long stationId = 0;
        HashMap<Long, Integer> stationIdToDroneCount = new HashMap<>();
        List<Station> stations = stationRepository.findAll();
        //Iterates through all stations and gets the number of drones in each station and saves it in a hashmap
        for (Station station : stations) {
            stationIdToDroneCount.put(station.getId(), station.getDrone().size());
            System.out.println(station.getDrone().size());
        }
        //Iterates through the hashmap and gets the station with the least number of drones
        for (int i = 0; i < stationIdToDroneCount.size(); i++) {
            if (droneCount > stationIdToDroneCount.get((long) i+1)) {
                droneCount = stationIdToDroneCount.get((long) i+1);
                stationId = (long) i + 1 ;
            }
        }
        return stationId;
    }
}
