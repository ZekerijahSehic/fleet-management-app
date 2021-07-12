package com.zekerijah.fleetmanagement.service;

import com.zekerijah.fleetmanagement.model.Location;
import com.zekerijah.fleetmanagement.repository.LocationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LocationService {

    @Autowired
    private LocationRepository locationRepository;

    public List<Location> getAllLocations(){
        return locationRepository.findAll();
    }

    public Location save(Location location){
        return locationRepository.save(location);
    }

    public Optional<Location> findById(Integer id){
        return locationRepository.findById(id);
    }

    public void delete(Integer id){
        locationRepository.deleteById(id);
    }
}
