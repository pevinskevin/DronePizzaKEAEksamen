package com.pevinskevin.dronepizza.Service;
import com.pevinskevin.dronepizza.Model.Station;
import com.pevinskevin.dronepizza.Reposittory.StationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
